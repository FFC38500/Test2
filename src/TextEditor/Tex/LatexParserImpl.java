/* The following code was generated by JFlex 1.4.1 on 25/04/2020 13:06 */

/*
 * 04/23/2019
 *
 * Maxence Miguel-Brebion 
 *
 * Latex Parser : improve code and format
 * 
 * 
 */
package TextEditor.Tex;
import java.io.IOException;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 25/04/2020 13:06 from the specification file
 * <tt>/Users/mbrebion/NetBeansProjects/ExerciceExplorer/src/TextEditor/Tex/LatexParser.flex</tt>
 */
public class LatexParserImpl extends LatexParserBase {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int BLOCK_A = 2;
  public static final int YYINITIAL = 0;
  public static final int BLOCK_Q = 1;
  public static final int BRACKET_BLOCK = 3;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\5\1\17\1\0\1\5\23\0\1\5\3\6\1\32\1\31"+
    "\1\6\1\4\5\6\1\1\1\3\1\6\12\2\6\6\5\1\1\34"+
    "\12\1\1\40\1\22\11\1\1\6\1\11\1\6\1\6\1\1\1\0"+
    "\1\21\1\12\1\25\1\20\1\13\1\1\1\14\1\1\1\15\2\1"+
    "\1\27\1\1\1\16\1\26\1\36\1\23\1\33\1\30\1\24\1\37"+
    "\2\1\1\35\2\1\1\7\1\6\1\10\1\6\101\0\1\1\10\0"+
    "\1\1\26\0\1\1\1\0\1\1\4\0\5\1\2\0\2\1\4\0"+
    "\1\1\1\0\1\1\2\0\1\1\1\0\2\1\uff03\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\1\1\2\2\1\3\1\2\1\4\2\1\1\5"+
    "\1\6\1\7\10\2\1\10\1\0\1\7\14\2\1\11"+
    "\6\2\1\0\6\2\1\0\4\2\1\0\1\12\1\2"+
    "\1\0\1\2\1\0\1\2\3\0\1\2\2\0\1\13"+
    "\2\0\1\2\1\0\2\13\1\14\1\2\1\0\1\2"+
    "\2\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[83];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\41\0\102\0\143\0\102\0\204\0\102\0\102"+
    "\0\245\0\102\0\306\0\347\0\102\0\102\0\u0108\0\u0129"+
    "\0\u014a\0\u016b\0\u018c\0\u01ad\0\u01ce\0\u01ef\0\u0210\0\306"+
    "\0\u0231\0\u0252\0\u0273\0\u0294\0\u02b5\0\u02d6\0\u02f7\0\u0318"+
    "\0\u0339\0\u035a\0\u037b\0\u039c\0\u03bd\0\u03de\0\u03ff\0\u0420"+
    "\0\u0441\0\u0462\0\u0483\0\u04a4\0\u04c5\0\u04e6\0\u0507\0\u0528"+
    "\0\u0549\0\u056a\0\u058b\0\u05ac\0\u05cd\0\u05ee\0\u060f\0\u0630"+
    "\0\u0651\0\u0672\0\u0693\0\u06b4\0\u06d5\0\u06f6\0\u0717\0\u0738"+
    "\0\u0759\0\u077a\0\u079b\0\u07bc\0\u07dd\0\u07fe\0\u081f\0\u0840"+
    "\0\u0861\0\u0882\0\u08a3\0\102\0\u08c4\0\u0861\0\u08e5\0\u0906"+
    "\0\u0927\0\u0948\0\u0969";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[83];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\3\6\1\7\1\10\1\6\2\7\1\11\5\6"+
    "\1\12\11\6\1\13\1\14\6\6\7\5\1\15\1\16"+
    "\6\5\1\0\21\5\41\0\1\5\3\6\1\7\1\10"+
    "\1\6\1\15\1\17\1\20\5\6\1\12\11\6\1\13"+
    "\1\14\6\6\1\0\3\6\2\0\1\6\2\0\1\21"+
    "\5\6\1\0\11\6\2\0\6\6\1\0\3\6\2\0"+
    "\3\6\1\21\1\22\1\23\3\6\1\0\1\6\1\24"+
    "\2\6\1\25\3\6\1\26\2\0\3\6\1\27\2\6"+
    "\1\0\16\30\1\0\11\30\2\0\6\30\1\0\16\31"+
    "\1\0\11\31\2\0\6\31\5\0\1\17\1\0\1\32"+
    "\7\0\1\17\22\0\3\6\2\0\3\6\1\21\1\22"+
    "\1\23\3\6\1\0\1\6\1\24\2\6\1\33\4\6"+
    "\2\0\6\6\1\0\3\6\2\0\3\6\1\21\5\6"+
    "\1\0\11\6\2\0\6\6\1\0\3\6\2\0\1\6"+
    "\2\0\1\21\1\6\1\34\3\6\1\0\11\6\2\0"+
    "\6\6\1\0\3\6\2\0\1\6\2\0\1\21\4\6"+
    "\1\35\1\0\3\6\1\36\5\6\2\0\6\6\1\0"+
    "\3\6\2\0\1\6\2\0\1\21\5\6\1\0\1\37"+
    "\10\6\2\0\6\6\1\0\3\6\2\0\1\6\2\0"+
    "\1\21\3\6\1\40\1\6\1\0\5\6\1\41\3\6"+
    "\2\0\6\6\1\0\3\6\2\0\1\6\2\0\1\21"+
    "\5\6\1\0\6\6\1\42\2\6\2\0\6\6\1\0"+
    "\3\6\2\0\1\6\2\0\1\21\5\6\1\0\1\6"+
    "\1\43\7\6\2\0\6\6\1\0\16\31\1\0\11\31"+
    "\1\0\1\7\6\31\5\0\1\32\11\0\1\32\22\0"+
    "\3\6\2\0\1\6\2\0\1\21\5\6\1\0\5\6"+
    "\1\41\3\6\2\0\6\6\1\0\3\6\2\0\1\6"+
    "\2\0\1\21\2\6\1\44\2\6\1\0\11\6\2\0"+
    "\6\6\1\0\3\6\2\0\1\6\2\0\1\21\5\6"+
    "\1\0\1\45\5\6\1\46\2\6\2\0\6\6\1\0"+
    "\3\6\2\0\1\6\1\47\1\0\1\21\5\6\1\0"+
    "\11\6\2\0\6\6\1\0\3\6\2\0\1\6\2\0"+
    "\1\21\5\6\1\0\1\50\10\6\2\0\6\6\1\0"+
    "\3\6\2\0\1\6\2\0\1\21\5\6\1\0\4\6"+
    "\1\51\4\6\2\0\6\6\1\0\3\6\2\0\1\6"+
    "\2\0\1\21\5\6\1\0\6\6\1\52\2\6\2\0"+
    "\6\6\1\0\3\6\2\0\1\6\2\0\1\21\5\6"+
    "\1\0\11\6\2\0\4\6\1\53\1\6\1\0\3\6"+
    "\2\0\1\6\2\0\1\21\5\6\1\0\11\6\2\0"+
    "\1\54\5\6\1\0\3\6\2\0\1\6\2\0\1\21"+
    "\3\6\1\55\1\6\1\0\11\6\2\0\6\6\1\0"+
    "\3\6\2\0\1\6\1\56\1\0\1\21\5\6\1\0"+
    "\11\6\2\0\6\6\1\0\3\6\2\0\1\6\2\0"+
    "\1\21\4\6\1\57\1\0\11\6\2\0\6\6\17\0"+
    "\1\47\22\0\3\6\2\0\1\6\2\0\1\21\5\6"+
    "\1\0\2\6\1\36\6\6\2\0\6\6\1\0\3\6"+
    "\2\0\1\6\2\0\1\21\5\6\1\0\11\6\2\0"+
    "\1\60\5\6\1\0\3\6\2\0\1\6\2\0\1\21"+
    "\5\6\1\0\7\6\1\61\1\6\2\0\6\6\1\0"+
    "\3\6\2\0\1\6\2\0\1\21\5\6\1\0\10\6"+
    "\1\62\2\0\6\6\1\0\3\6\2\0\1\6\2\0"+
    "\1\21\5\6\1\0\4\6\1\63\4\6\2\0\6\6"+
    "\1\0\3\6\2\0\1\6\2\0\1\21\4\6\1\64"+
    "\1\0\11\6\2\0\6\6\1\0\2\65\7\0\5\65"+
    "\1\0\11\65\2\0\6\65\1\0\3\6\2\0\1\6"+
    "\2\0\1\21\5\6\1\0\5\6\1\66\3\6\2\0"+
    "\6\6\1\0\3\6\2\0\1\6\2\0\1\21\1\6"+
    "\1\67\3\6\1\0\11\6\2\0\6\6\1\0\3\6"+
    "\2\0\1\6\2\0\1\21\5\6\1\0\10\6\1\70"+
    "\2\0\6\6\1\0\3\6\2\0\1\6\2\0\1\21"+
    "\5\6\1\0\11\6\2\0\5\6\1\27\1\0\3\6"+
    "\2\0\1\6\2\0\1\21\3\6\1\71\1\6\1\0"+
    "\11\6\2\0\6\6\1\0\3\6\2\0\1\6\1\72"+
    "\1\0\1\21\5\6\1\0\11\6\2\0\6\6\1\0"+
    "\2\65\5\0\1\73\1\0\5\65\1\0\11\65\2\0"+
    "\6\65\1\0\3\6\2\0\1\6\2\0\1\21\1\6"+
    "\1\36\3\6\1\0\11\6\2\0\6\6\1\0\3\6"+
    "\2\0\1\6\2\0\1\21\5\6\1\0\11\6\2\0"+
    "\1\6\1\74\4\6\1\0\3\6\2\0\1\6\1\75"+
    "\1\0\1\21\5\6\1\0\11\6\2\0\6\6\1\0"+
    "\3\6\2\0\1\6\2\0\1\21\1\6\1\76\3\6"+
    "\1\0\11\6\2\0\6\6\1\0\2\77\7\0\5\77"+
    "\1\0\11\77\2\0\6\77\17\0\1\73\22\0\3\6"+
    "\2\0\1\6\2\0\1\21\5\6\1\0\11\6\2\0"+
    "\2\6\1\100\3\6\2\0\1\101\37\0\3\6\2\0"+
    "\1\6\1\102\1\0\1\21\5\6\1\0\11\6\2\0"+
    "\6\6\1\0\2\77\5\0\1\103\1\0\5\77\1\0"+
    "\11\77\2\0\6\77\1\0\3\6\2\0\1\6\2\0"+
    "\1\21\1\6\1\104\3\6\1\0\11\6\2\0\6\6"+
    "\2\0\1\101\1\105\4\0\1\106\31\0\6\102\1\0"+
    "\1\107\1\110\5\102\1\0\11\102\2\0\6\102\1\0"+
    "\16\111\1\0\11\111\2\0\6\111\1\0\3\6\2\0"+
    "\1\6\2\0\1\21\5\6\1\0\11\6\2\0\1\112"+
    "\5\6\2\0\1\105\5\0\1\106\37\0\1\113\50\0"+
    "\1\114\22\0\7\102\1\115\1\110\5\102\1\0\11\102"+
    "\2\0\6\102\17\0\1\116\22\0\3\6\2\0\1\6"+
    "\2\0\1\21\5\6\1\0\5\6\1\117\3\6\2\0"+
    "\6\6\2\0\1\120\37\0\6\102\1\0\1\107\1\110"+
    "\5\102\1\114\11\102\2\0\6\102\1\0\3\6\2\0"+
    "\1\6\2\0\1\21\3\6\1\121\1\6\1\0\11\6"+
    "\2\0\6\6\2\0\1\120\1\122\4\0\1\123\31\0"+
    "\3\6\2\0\1\6\2\0\1\21\5\6\1\0\5\6"+
    "\1\71\3\6\2\0\6\6\2\0\1\122\5\0\1\123"+
    "\37\0\1\47\31\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2442];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\10\1\0\1\11\1\1\2\11\1\1\1\11"+
    "\2\1\2\11\12\1\1\0\24\1\1\0\6\1\1\0"+
    "\4\1\1\0\2\1\1\0\1\1\1\0\1\1\3\0"+
    "\1\1\2\0\1\1\2\0\1\1\1\0\1\11\3\1"+
    "\1\0\1\1\2\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[83];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */

	/**
	 * Constructor.  This must be here because JFlex does not generate a
	 * no-parameter constructor.
	 */
	public LatexParserImpl() {
            super();
	}

        
 @Override
    public void startParsing() {
        yybegin(YYINITIAL);
        try {
            yylex();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
            



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LatexParserImpl(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public LatexParserImpl(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 156) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public boolean yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 9: 
          { startBracketBloc(yytext());
          }
        case 13: break;
        case 12: 
          { this.startBlock();
          }
        case 14: break;
        case 4: 
          { this.endLine();
          }
        case 15: break;
        case 6: 
          { addCloseBracket();
          }
        case 16: break;
        case 10: 
          { this.endBlock();
          }
        case 17: break;
        case 3: 
          { this.addWhiteSpace();
          }
        case 18: break;
        case 8: 
          { this.currentLine += yytext();
          }
        case 19: break;
        case 5: 
          { addOpenBracket();
          }
        case 20: break;
        case 11: 
          { this.currentLine+=yytext().trim(); this.endLine();
          }
        case 21: break;
        case 2: 
          { this.currentLine+=yytext();
          }
        case 22: break;
        case 7: 
          { endBracketBlock() ;
          }
        case 23: break;
        case 1: 
          { System.err.println("not catched : " + yytext());
          }
        case 24: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            switch (zzLexicalState) {
            case YYINITIAL: {
              this.endLine(); return false;
            }
            case 84: break;
            case BLOCK_Q: {
              return false;
            }
            case 85: break;
            case BRACKET_BLOCK: {
              return false;
            }
            case 86: break;
            default:
            return false;
            }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
