package com.example.humo2.UtilOfb;

import com.example.humo2.dto.CardsDto;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/*
 *
 *  @A Sabirov Jakhongir
 *
 */
public class OfbUtils {
    public static final String sql = "  select au.symbol_1 xxxflag,\n" +
            "                              au.symbol_9 account,\n" +
            "                              au.number_7 balance,\n" +
            "                              au.symbol_2 branch,\n" +
            "                              au.symbol_10 cardBelonging,\n" +
            "                              'DEBET' cardKind,\n" +
            "                              au.number_4 cardListVis,\n" +
            "                              au.symbol_4 cardNumberMask,\n" +
            "                              au.symbol_3 cardSort,\n" +
            "                              au.symbol_11 cardholderName,\n" +
            "                              au.symbol_12 currencyCode,\n" +
            "                              au.symbol_13 currencyIsoCode,\n" +
            "                              au.symbol_6 EMBOSSED_NAME,\n" +
            "                              to_date(au.symbol_5, 'dd.mm.yyyy') expirationDate,\n" +
            "                              au.symbol_17 extId,\n" +
            "                              au.number_5 rejection,\n" +
            "                              au.symbol_14 serviceTerms,\n" +
            "                              au.symbol_7 STATE,\n" +
            "                              au.number_6 tempBlocking,\n" +
            "                              au.symbol_14 type,\n" +
            "                              1 visibleAccount,\n" +
            "                              au.symbol_15 phoneNumber,\n" +
            "                              au.symbol_16 /*cardNumber*/,\n" +
            "                              au.number_2 xxxCLIENT_ID,\n" +
            "                              au.number_3 xxxCONTRACT_ID,\n" +
            "                              0 isAbroadUsing,\n" +
            "                              au.number_8 isInternetUsing,\n" +
            "                              1 replWOutConv,\n" +
            "                              1 withdWOutConv\n" +
            "                         from ibs.bss_au_reptemp_l au";


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "    <soapenv:Body>\n" +
                "        <queryAccountBalanceByCardResponse soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <ResponseInfo href=\"#id0\"/>\n" +
                "            <Details href=\"#id1\"/>\n" +
                "        </queryAccountBalanceByCardResponse>\n" +
                "        <multiRef id=\"id0\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns1:OperationResponseInfo\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"urn:issuing_v_01_02_xsd\">\n" +
                "            <response_code xsi:type=\"xsd:integer\">0</response_code>\n" +
                "            <error_description xsi:type=\"xsd:string\" xsi:nil=\"true\"/>\n" +
                "            <error_action xsi:type=\"xsd:string\" xsi:nil=\"true\"/>\n" +
                "            <EXTERNAL_SESSION_ID xsi:type=\"xsd:string\">eUqx669fQlmADk2EGDHBgsJI91lzAhPgvAMrjqT672UtilwSP6d3CkAL99Jr</EXTERNAL_SESSION_ID>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id1\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns2:ListType_Generic\" xmlns:ns2=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <row href=\"#id2\"/>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id2\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns3:RowType_Generic\" xmlns:ns3=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <item href=\"#id3\"/>\n" +
                "            <item href=\"#id4\"/>\n" +
                "            <item href=\"#id5\"/>\n" +
                "            <item href=\"#id6\"/>\n" +
                "            <item href=\"#id7\"/>\n" +
                "            <item href=\"#id8\"/>\n" +
                "            <item href=\"#id9\"/>\n" +
                "            <item href=\"#id10\"/>\n" +
                "            <item href=\"#id11\"/>\n" +
                "            <item href=\"#id12\"/>\n" +
                "            <item href=\"#id13\"/>\n" +
                "            <item href=\"#id14\"/>\n" +
                "            <item href=\"#id15\"/>\n" +
                "            <item href=\"#id16\"/>\n" +
                "            <item href=\"#id17\"/>\n" +
                "            <item href=\"#id18\"/>\n" +
                "            <item href=\"#id19\"/>\n" +
                "            <item href=\"#id20\"/>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id4\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns4:ItemType_Generic\" xmlns:ns4=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">EXPIRY1</name>\n" +
                "            <value xsi:type=\"xsd:string\">2023-11-30T00:00:00</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id14\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns5:ItemType_Generic\" xmlns:ns5=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">STOP_CAUSE</name>\n" +
                "            <value xsi:type=\"xsd:string\">0</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id6\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns6:ItemType_Generic\" xmlns:ns6=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">ACCOUNT_NO</name>\n" +
                "            <value xsi:type=\"xsd:string\">69803</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id19\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns7:ItemType_Generic\" xmlns:ns7=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">CRD</name>\n" +
                "            <value xsi:type=\"xsd:string\">0</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id5\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns8:ItemType_Generic\" xmlns:ns8=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">CARD_STATUS</name>\n" +
                "            <value xsi:type=\"xsd:string\">0</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id7\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns9:ItemType_Generic\" xmlns:ns9=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">CARD_ACCT</name>\n" +
                "            <value xsi:type=\"xsd:string\">22618840060218460001</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id13\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns10:ItemType_Generic\" xmlns:ns10=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">C_ACCNT_TYPE</name>\n" +
                "            <value xsi:type=\"xsd:string\">00</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id16\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns11:ItemType_Generic\" xmlns:ns11=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">BANK_C</name>\n" +
                "            <value xsi:type=\"xsd:string\">55</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id20\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns12:ItemType_Generic\" xmlns:ns12=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">CRD_EXPIRY</name>\n" +
                "            <value xsi:type=\"xsd:string\"/>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id8\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns13:ItemType_Generic\" xmlns:ns13=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">ACC_STATUS</name>\n" +
                "            <value xsi:type=\"xsd:string\">0</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id17\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns14:ItemType_Generic\" xmlns:ns14=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">GROUPC</name>\n" +
                "            <value xsi:type=\"xsd:string\">01</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id11\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns15:ItemType_Generic\" xmlns:ns15=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">LOCKED_AMOUNT</name>\n" +
                "            <value xsi:type=\"xsd:string\">0</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id3\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns16:ItemType_Generic\" xmlns:ns16=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">CARD</name>\n" +
                "            <value xsi:type=\"xsd:string\">4108590171136685</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id18\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns17:ItemType_Generic\" xmlns:ns17=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">CCY_EXP</name>\n" +
                "            <value xsi:type=\"xsd:string\">2</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id9\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns18:ItemType_Generic\" xmlns:ns18=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">CCY</name>\n" +
                "            <value xsi:type=\"xsd:string\">USD</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id15\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns19:ItemType_Generic\" xmlns:ns19=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">MAIN_ROW</name>\n" +
                "            <value xsi:type=\"xsd:string\">69818</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id12\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns20:ItemType_Generic\" xmlns:ns20=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">AVAIL_AMOUNT</name>\n" +
                "            <value xsi:type=\"xsd:string\">3</value>\n" +
                "        </multiRef>\n" +
                "        <multiRef id=\"id10\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns21:ItemType_Generic\" xmlns:ns21=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <name xsi:type=\"xsd:string\">END_BAL</name>\n" +
                "            <value xsi:type=\"xsd:string\">1003</value>\n" +
                "        </multiRef>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>\n";


        String path = "<?xml version=\"1.0\"?>\n" +
                "<howto>\n" +
                "  <topic name=\"Java\">\n" +
                "      <url>http://www.rgagnonjavahowto.htm</url>\n" +
                "  <car>taxi</car>\n" +
                "  </topic>\n" +
                "  <topic name=\"PowerBuilder\">\n" +
                "       <url>http://www.rgagnon/pbhowto.htm</url>\n" +
                "       <url>http://www.rgagnon/pbhowtonew.htm</url>\n" +
                "  </topic>\n" +
                "  <topic name=\"Javascript\">\n" +
                "        <url>http://www.rgagnon/jshowto.htm</url>\n" +
                "  </topic>\n" +
                " <topic name=\"VBScript\">\n" +
                "       <url>http://www.rgagnon/vbshowto.htm</url>\n" +
                " </topic>\n" +
                " </howto>";


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new InputSource(new StringReader(xml)));


        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xPath = xPathfactory.newXPath();
        xPath.setNamespaceContext(new MyNamespaceContext());

        //  //multiRef[./name/text() = 'TRAN_AMT']
        String expression = "/soapenv:Envelope/soapenv:Body";
        // String exp = "/howto";
        NodeList dates = null;
        String pathes = "";
        try {
            pathes = (String) xPath.compile(expression).evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        System.out.println(pathes);

    }

    private static class MyNamespaceContext implements NamespaceContext {

        public String getNamespaceURI(String prefix) {
            if("soapenv".equals(prefix)) {
                return "";
            }
            return null;
        }

        public String getPrefix(String namespaceURI) {
            return null;
        }

        public Iterator getPrefixes(String namespaceURI) {
            return null;
        }

    }

    public String generateAnswer(CardsDto cardsDto){
        StringBuilder builder = new StringBuilder();
        builder.append(generateWithTag(cardsDto.getAccount(),"account"));
        builder.append(generateWithTag(cardsDto.getBalance(),"balance"));
        builder.append(generateWithTag(cardsDto.getBranch(),"branch"));
        builder.append(generateWithTag(cardsDto.getCardBelonging(),"cardBelonging"));
        builder.append(generateWithTag(cardsDto.getCardKind(),"cardKind"));
        builder.append(generateWithTag(cardsDto.getCardListVist(),"cardListVis"));
        builder.append(generateWithTag(cardsDto.getCardNumberMask(),"cardNumberMask"));
        builder.append(generateWithTag(cardsDto.getCardSort(),"cardSort"));
        builder.append(generateWithTag(cardsDto.getCardHolderName(),"cardHolderName"));
        builder.append(generateWithTag(cardsDto.getCurrencyCode(),"currencyCode"));
        builder.append(generateWithTag(cardsDto.getCurrencyIsoCode(),"currencyIsoCode"));
        builder.append(generateWithTag(cardsDto.getEmbossedName(),"embossedName"));
        builder.append(generateWithTag(cardsDto.getExpirationDate(),"expirationDate"));
        builder.append(generateWithTag(cardsDto.getExtId(),"extId"));
        builder.append(generateWithTag(cardsDto.getRejection(),"rejection"));
        builder.append(generateWithTag(cardsDto.getServiceTerms(),"serviceTerms"));
        builder.append(generateWithTag(cardsDto.getState(),"state"));
        builder.append(generateWithTag(cardsDto.getTempBlocking(),"tempLocking"));
        builder.append(generateWithTag(cardsDto.getType(),"type"));
        builder.append(generateWithTag(cardsDto.getVisibleAccount(),"visibleAccount"));
        builder.append(generateWithTag(cardsDto.getPhoneNumber(),"phoneNumber"));
        builder.append(generateWithTag(cardsDto.getCardNumber(),"cardNumber"));
        builder.append(generateWithTag(cardsDto.getClientId(),"clientId"));
        builder.append(generateWithTag(cardsDto.getContractId(),"contractId"));
        builder.append(generateWithTag(cardsDto.getIsAbroadUsing(),"isAbroadUsing"));
        builder.append(generateWithTag(cardsDto.getIsInternetUsing(),"isInternetUsing"));
        builder.append(generateWithTag(cardsDto.getReplwoutConv(),"replvoutConv"));
        builder.append(generateWithTag(cardsDto.getWithdraw(),"withDraw"));
        return builder.toString();
    }

    private static String  generateWithTag (String value,String tag){
        return "<" + tag +">" + value + "</" + tag + ">";
    }
    private static String  generateWithTag (int value,String tag){
        return "<" + tag +">" + value + "</" + tag + ">";
    }
    private static String  generateWithTag (double value,String tag){
        return "<" + tag +">" + value + "</" + tag + ">";
    }
    private static String  generateWithTag (Date value, String tag){
        return "<" + tag +">" + value + "</" + tag + ">";
    }

}
