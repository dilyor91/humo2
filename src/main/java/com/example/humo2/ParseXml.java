package com.example.humo2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *
 *  @A Sabirov Jakhongir
 *
 */
public class ParseXml {

    private final static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
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
            "            <EXTERNAL_SESSION_ID xsi:type=\"xsd:string\">Oiu67A4c9JerP48uKddBq1orLFtm3q6u17CryQGj8BTHp75u4yV0YcR2rN6i</EXTERNAL_SESSION_ID>\n" +
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
            "        <multiRef id=\"id10\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns4:ItemType_Generic\" xmlns:ns4=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">END_BAL</name>\n" +
            "            <value xsi:type=\"xsd:string\">10097149</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id8\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns5:ItemType_Generic\" xmlns:ns5=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">ACC_STATUS</name>\n" +
            "            <value xsi:type=\"xsd:string\">0</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id13\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns6:ItemType_Generic\" xmlns:ns6=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">C_ACCNT_TYPE</name>\n" +
            "            <value xsi:type=\"xsd:string\">00</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id5\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns7:ItemType_Generic\" xmlns:ns7=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">CARD_STATUS</name>\n" +
            "            <value xsi:type=\"xsd:string\">0</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id16\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns8:ItemType_Generic\" xmlns:ns8=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">BANK_C</name>\n" +
            "            <value xsi:type=\"xsd:string\">55</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id17\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns9:ItemType_Generic\" xmlns:ns9=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">GROUPC</name>\n" +
            "            <value xsi:type=\"xsd:string\">01</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id19\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns10:ItemType_Generic\" xmlns:ns10=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">CRD</name>\n" +
            "            <value xsi:type=\"xsd:string\">0</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id14\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns11:ItemType_Generic\" xmlns:ns11=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">STOP_CAUSE</name>\n" +
            "            <value xsi:type=\"xsd:string\">0</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id3\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns12:ItemType_Generic\" xmlns:ns12=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">CARD</name>\n" +
            "            <value xsi:type=\"xsd:string\">410859SBBCKZ7998</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id9\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns13:ItemType_Generic\" xmlns:ns13=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">CCY</name>\n" +
            "            <value xsi:type=\"xsd:string\">UZS</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id20\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns14:ItemType_Generic\" xmlns:ns14=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">CRD_EXPIRY</name>\n" +
            "            <value xsi:type=\"xsd:string\"/>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id7\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns15:ItemType_Generic\" xmlns:ns15=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">CARD_ACCT</name>\n" +
            "            <value xsi:type=\"xsd:string\">22618000999407679003</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id18\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns16:ItemType_Generic\" xmlns:ns16=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">CCY_EXP</name>\n" +
            "            <value xsi:type=\"xsd:string\">2</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id4\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns17:ItemType_Generic\" xmlns:ns17=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">EXPIRY1</name>\n" +
            "            <value xsi:type=\"xsd:string\">2023-04-30T00:00:00</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id11\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns18:ItemType_Generic\" xmlns:ns18=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">LOCKED_AMOUNT</name>\n" +
            "            <value xsi:type=\"xsd:string\">0</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id12\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns19:ItemType_Generic\" xmlns:ns19=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">AVAIL_AMOUNT</name>\n" +
            "            <value xsi:type=\"xsd:string\">97149</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id15\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns20:ItemType_Generic\" xmlns:ns20=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">MAIN_ROW</name>\n" +
            "            <value xsi:type=\"xsd:string\">55252</value>\n" +
            "        </multiRef>\n" +
            "        <multiRef id=\"id6\" soapenc:root=\"0\" soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xsi:type=\"ns21:ItemType_Generic\" xmlns:ns21=\"urn:issuing_v_01_02_xsd\" xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
            "            <name xsi:type=\"xsd:string\">ACCOUNT_NO</name>\n" +
            "            <value xsi:type=\"xsd:string\">55217</value>\n" +
            "        </multiRef>\n" +
            "    </soapenv:Body>\n" +
            "</soapenv:Envelope>\n";

    public static void main(String[] args)
    {

        try {
        String    output = getBalance(xml, "multiRef");
            System.out.print("Response Balance is "+ output);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Document loadXMLString(String response) throws Exception
    {
        DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(response));

        return db.parse(is);
    }

    public static String getBalance(String response, String tagName) throws Exception {
        Document xmlDoc = loadXMLString(response);
        NodeList nodeList = xmlDoc.getElementsByTagName(tagName);

        String amount = "";
        List<String> ids = new ArrayList<String>(nodeList.getLength());
        for(int i=0;i<nodeList.getLength(); i++)
        {
            Node x = nodeList.item(i);
            for(int j = 0 ; j < x.getChildNodes().getLength();j ++)
            {
                // nodeList.item(18).getChildNodes().item(3).getFirstChild()
                if(x.getChildNodes().item(j).getFirstChild() != null)
                {
                    if(x.getChildNodes().item(j).getTextContent().equals("AVAIL_AMOUNT"))
                    {
                        // Todo Need to fix in the future + 2 custom
                        return x.getChildNodes().item(j + 2).getTextContent();
                    }
                }

            }
        }
        return amount;
    }
}
