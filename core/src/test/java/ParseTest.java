import model.SegmentPattern;
import model.SegmentType;
import model.URIPattern;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseTest {
  @Test
  public void testSegmentParsing() {
    String seg = "test(cap1)::key1#anchor[val1=(cap2),val2=123,val3=\\:def\\:]";
    SegmentPattern p = new SegmentPattern(SegmentType.NODE, seg);
    System.out.println(p.attributes);
    System.out.println(p.attributes.keySet());
    System.out.println(p.attributes.values());
    System.out.println(p.captures);
    System.out.println(p);
    assertEquals("test(cap1)", p.text.text);
    assertEquals("key1", p.type.text);
    assertEquals("anchor", p.anchor);
    assertEquals(3, p.attributes.size());
    assertEquals(2, p.captures.size());
  }

  @Test
  public void testURIParsing() {
    String lang = "JAVA";
    String file = "root//(layoutFile).xml";
    String element = "(elementTag)::XMLTag#func[idx=1]/~attr~/android\\:id//\"@id\\/(widgetID)\"";
    String branch1 = "@func//**//(bindingVar)::VarDecl/~varType~/(layoutName)Binding";
    String branch2 = "(function)::FuncDecl//**//(bindingVar).(widgetID)";
    URIPattern uriPattern = new URIPattern("test", lang, file, element, null, Arrays.asList(branch1, branch2));
    System.out.println(uriPattern.captures);
  }
}
