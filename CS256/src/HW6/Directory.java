package HW6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *  A simple representation of directories/folders.
 *
 * @author Choong-Soo Lee
 */
public class Directory {
    // instance variables
    private String name;
    private List<Directory> directories;
    private List<File> files;

    // constructors

    /**
     * Constructs an empty directory (no files or directories).
     *
     * @param aName the name of the Directory object.
     */
    public Directory(String aName) {
        this(aName, new ArrayList<Directory>(), new ArrayList<File>());
    }

    /**
     * Constructs a directory.
     *
     * @param aName           the name of the Directory object.
     * @param someDirectories the directories in the Directory object.
     * @param someFiles       the files in the Directory object.
     */
    public Directory(String aName, List<Directory> someDirectories, List<File> someFiles) {
        if (aName == null || aName.length() == 0 || someDirectories == null || someFiles == null) {
            throw new IllegalArgumentException("The name cannot be null or an empty string. Directories and files cannot be null.");
        }
        this.name = aName;
        this.directories = someDirectories;
        this.files = someFiles;
    }

    // instance methods

    /**
     * Gets the name of this Directory object.
     *
     * @return the name of this Directory objects.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of Directory objects in this Directory object.
     *
     * @return the list of Directory objects.
     */
    public List<Directory> getDirectories() {
        return directories;
    }


    /**
     * Gets the list of File objects in this Directory object.
     *
     * @return the list of File objects.
     */
    public List<File> getFiles() {
        return files;
    }

    /**
     * Add a new File object to this Directory object.
     *
     * @param aFile the File object to add to this Directory object.
     */
    public void addFile(File aFile) {
        this.files.add(aFile);
    }

    /**
     * Add a new Directory object to this Directory object.
     *
     * @param aDirectory the Directory object to add to this Directory object.
     */
    public void addDirectory(Directory aDirectory) {
        this.directories.add(aDirectory);
    }


    /**
     * Returns the size of al files within a given directory
     *
     * @return the sum of the file sizes
     */
    public int size() {
        int sum = 0;
        // check if it is empty, just a check for a case with both files and directories
        if (this.directories.isEmpty()) {
            for (File file : this.files) {
                sum += file.getSize();
            }
        } else {
            // checking each individual directory and if it has files
            for (Directory directory : this.directories) {
                if (!this.files.isEmpty()) {
                    for (File file : this.files)
                        sum += file.getSize();
                }
                // telling the size to the directory, so it can compute with other directories
                sum += directory.size();
            }
        }
        return sum;
    }

    /**
     * @param target reprents the String File type we want to count
     * @return the number of files with the type of target
     */
    public int countFileType(String target) {
        int count = 0;
        // if the given file equals the target if it is increment count
        for (File file : this.files) {
            if (file.getType().equals(target))
                count++;

        }
        // search the directories for the files, if it has files
        // check to see if it's the same as target increment count
        for (Directory directory : this.directories) {
            for (File file : this.files) {
                if (file.getType().equals(target))
                    count++;
            }
            // add all the subdirectories counts to root directory count
            count += directory.countFileType(target);
        }

        return count;
    }

    /**
     *
     * @param targetName the target name for the path
     * @return the path that follows targetName
     */
    public String findFileByName(String targetName) {
        // base case
        for (File file : this.files) {
            if (targetName.equals(file.getName())) {
                // If the target file is found in the current directory, return its name
                return file.getName();
            }
        }

        for (Directory directory : this.directories) {
            // Recursively search for the file
            String path = directory.findFileByName(targetName);
            if (!path.isEmpty()) {
                return directory.getName() + "/" + path;
            }
        }
        return "";  // No file with the specified name found in this directory or its subdirectories

    }

    /**
     *
     * @return the path for the largest file size
     */
    public String findLargestFile() {
        File largest = findMaxFile();
        if (largest == null)
            return "No file found.";

        return this.findFileByName(largest.getName());

    }

    /**
     * Private helper method that returns file with the largest size
     * @return file with the largest size
     */
    private File findMaxFile() {
        File largest = null;
        int size = 0;

        for (File file : files) {
            // Update the largest file
            if (file.getSize() > size) {
                largest = file;
                size = largest.getSize();
            }
        }
        for (Directory directory : directories) {
            // recursion call for largest file in each directory
            File check = directory.findMaxFile();
            // update largest
            if (check != null && check.getSize() > size) {
                largest = check;
                size = largest.getSize();
            }
        }
        return largest;
}
}
