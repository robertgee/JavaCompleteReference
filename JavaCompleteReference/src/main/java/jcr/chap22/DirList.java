package jcr.chap22;

// Display a directory.  
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes; 
 
class DirList { 
  public static void main(String args[]) { 
    String dirname = "\\MyDir"; 
 
    // Obtain and manage a directory stream within an ARM Block. 
    try ( DirectoryStream<Path> dirstrm = 
            Files.newDirectoryStream(Paths.get(dirname)) ) 
    { 
      System.out.println("Directory of " + dirname); 
  
      // Because DirectoryStream implements Iterable, we 
      // can use a "foreach" loop to display the directory. 
      for(Path entry : dirstrm) { 
        BasicFileAttributes attribs = 
             Files.readAttributes(entry, BasicFileAttributes.class); 
 
        if(attribs.isDirectory()) 
          System.out.print("<DIR> "); 
        else 
          System.out.print("      "); 
 
        System.out.println(entry.getName(1)); 
      } 
    } catch(InvalidPathException e) { 
      System.out.println("Path Error " + e); 
    } catch(NotDirectoryException e) { 
      System.out.println(dirname + " is not a directory."); 
    } catch (IOException e) { 
      System.out.println("I/O Error: " + e); 
    } 
  } 
}
