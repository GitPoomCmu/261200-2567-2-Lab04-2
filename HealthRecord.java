class HealthRecord {
    private int height;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int DEFAULT_HEIGHT = 100;
    private static int tallestHeight = MIN_PERMITTED_HEIGHT - 1;
    private static int shortestHeight = MAX_PERMITTED_HEIGHT + 1;
    private static int counter = 0;
    private static int totalHeight = 0;
    private static int averageHeight;

    public HealthRecord(int height){
        if(height > MAX_PERMITTED_HEIGHT || height < MIN_PERMITTED_HEIGHT) this.height = DEFAULT_HEIGHT;
        else this.height = height;

        if(this.height > tallestHeight) tallestHeight = this.height;
        if(this.height < shortestHeight) shortestHeight = this.height;

        counter++;

        totalHeight += this.height;
        averageHeight = totalHeight / counter;
    }

    public int getHeight(){
        return this.height;
    }
    public void setHeight(int height){
        int prevHeight = this.height;

        if(height > MAX_PERMITTED_HEIGHT || height < MIN_PERMITTED_HEIGHT) this.height = DEFAULT_HEIGHT;
        else this.height = height;

        if(this.height > tallestHeight) tallestHeight = this.height;
        if(this.height < shortestHeight) shortestHeight = this.height;

        totalHeight += this.height - prevHeight;
        averageHeight = totalHeight / counter;
    }

    public static int getTallestHeight(){
        return tallestHeight;
    }
    public static int getShortestHeight(){
        return shortestHeight;
    }
    public static int getAverageHeight(){
        return averageHeight;
    }

    public void displayDetails() { 
        System.out.println("Height (cm): " + getHeight());
    }
    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.println("The average height (cm): " + getAverageHeight());
    }
}
