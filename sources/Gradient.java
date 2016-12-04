import java.awt.Color;

public class Gradient {

    private final int numColours;
    private int[][] colourTable;

    public Gradient(int numColours, Color... colours) {
        this.numColours = numColours;
        generateColourTable(colours);
    }

    private void generateColourTable(Color... colours) {
        colourTable = new int[numColours][];

        int curColour = 0;
        int gradesPerColour = numColours / colours.length;
        for (int grad = 0; grad < colours.length; grad++) {
            Color fromColour = colours[grad];
            Color toColour = colours[(grad+1)%colours.length];
            int startIndex = curColour * gradesPerColour;
            fillColour(startIndex, gradesPerColour, fromColour, toColour);
            curColour++;
        }
    }

    private void fillColour(int startIndex, int numGrades, Color fromColour, Color toColour) {
        for (int i = startIndex; i < startIndex + numGrades; i++) {
            //Get the average red, blue and green between the from and to colours at this index
            int r = fromColour.getRed() + (int) ((toColour.getRed() - fromColour.getRed()) * (i-startIndex) / numGrades);
            int g = fromColour.getGreen() + (int) ((toColour.getGreen() - fromColour.getGreen()) * (i-startIndex) / numGrades);
            int b = fromColour.getBlue() + (int) ((toColour.getBlue() - fromColour.getBlue()) * (i-startIndex) / numGrades);
            colourTable[i] = new int[] {r, g, b};
        }
    }

    public int[] getColor(double factor) {
        assert factor >= 0 && factor < 1;
        return colourTable[(int) (numColours * factor)];
    }

}
