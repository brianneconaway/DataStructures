package HW6;

/**
 * A simple representation of files.
 *
 * @author Choong-Soo Lee
 */
public class File {
    // instance variables
    private String name;
    private String type;
    private int size;

    // constructors

    /**
     * Constructs a new File object.
     *
     * @param aName the name of the File object.
     * @param aType the type of the File object.
     * @param aSize the size of the File object.
     */
    public File(String aName, String aType, int aSize) {
        if (aName == null || aName.length() == 0 || aType == null || aType.length() == 0 || aSize < 0) {
            throw new IllegalArgumentException("The name and type cannot be null or empty strings. The size cannot be negative.");
        }
        this.name = aName;
        this.type = aType;
        this.size = aSize;
    }

    // instance methods
    /**
     * Gets the name of this File object.
     *
     * @return the name of this File object.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type of this File object.
     *
     * @return the type of this File object.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the size of this File object.
     *
     * @return the size of this File object.
     */
    public int getSize() {
        return size;
    }
}
