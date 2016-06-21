package org.blagosvet.numerologyrevealed.v.console;

/**
 *
 * @author dmitri
 */
//import java.util.ArrayList;
import java.util.ArrayDeque;

/* Printing the result of calculation
 */
public class Booklet {

    //output stream types
    private final static short CONSOLE = 0;
    private final static short STREAM = 1;
    private final static short FILE = 2;
    private short streamType = CONSOLE;

    // output format types
    private final static short DEFAULT = 0;
    private final static short TEXT = 1;
    private final static short PDF = 2;
    private final static short HTML = 3;
    private short outputFormat = DEFAULT;

    public Booklet(ArrayDeque<String> data) {

        switch (outputFormat) {
            case DEFAULT:
                for (String line : data) {
                    System.out.println(line);
                }
                break;
            case TEXT:

                break;
            case PDF:

                break;
            case HTML:

                break;
        }
    }

    /**
     * @param output switches on an output type : (0 - default - on screen; 1 -
     * text file (UTF-8); 2 - PDF output; 3 - HTML/CSS; >=4 is 0)
     *
     */
    public void setOutputFormat(short output) {
        switch (output) {
            case 0:
                outputFormat = DEFAULT;
                break;
            case 1:
                outputFormat = TEXT;
                break;
            case 2:
                outputFormat = PDF;
                break;
            case 3:
                outputFormat = HTML;
                break;
            default:
                outputFormat = DEFAULT;
                break;
        }
    }

    /**
     * @param type switches on an output stream type : (0 - default - console; 1
     * - file; 2 - stream; >=3 is 0)
     *
     */
    public void setOutputStream(short type) {
        switch (type) {
            case 0:
                streamType = CONSOLE;
                break;
            case 1:
                streamType = FILE;
                break;
            case 2:
                streamType = STREAM;
                break;
            default:
                streamType = CONSOLE;
                break;
        }
    }
}
