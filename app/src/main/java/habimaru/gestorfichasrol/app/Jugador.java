package habimaru.gestorfichasrol.app;

import android.os.Environment;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Habimaru on 29/04/2014.
 */
public class Jugador {
    String nombre="";
    String jugador="";
    String partida="";
    String clase="";
    String raza="";
    String sexo="";

    int vit=0;
    int exp=0;

    //Físicos
    int fuerza=0;
    int destreza=0;
    int resistencia=0;

    //Sociales
    int carisma=0;
    int manipulacion=0;
    int apariencia=0;


    //Mentales
    int percepcion=0;
    int inteligencia=0;
    int astucia=0;

    //Info extra
    String disciplinas="";
    String defectos="";
    String virtudes="";

    /**
     * Constructor vacío. Lo implemento para no recibir nullpointerexception en la creacion de la actividad
     */
    public Jugador(){
    }

    /**
     * Serializa a xml el jugador
     */
    void toXML(){
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // root elements
        Document doc = docBuilder.newDocument();
        Element jugador = doc.createElement("Jugador");
        doc.appendChild(jugador);

        // set attribute to staff element
        jugador.setAttribute("nombre", this.nombre);
        jugador.setAttribute("jugador", this.jugador);
        jugador.setAttribute("partida", this.partida);
        jugador.setAttribute("clase", this.clase);
        jugador.setAttribute("raza", this.raza);
        jugador.setAttribute("sexo", this.sexo);
        jugador.setAttribute("vit", String.valueOf(this.vit));
        jugador.setAttribute("exp", String.valueOf(this.exp));
        jugador.setAttribute("fuerza", String.valueOf(this.fuerza));
        jugador.setAttribute("destreza", String.valueOf(this.destreza));
        jugador.setAttribute("resistencia", String.valueOf(this.resistencia));
        jugador.setAttribute("carisma", String.valueOf(this.carisma));
        jugador.setAttribute("manipulacion", String.valueOf(this.manipulacion));
        jugador.setAttribute("apariencia", String.valueOf(this.apariencia));
        jugador.setAttribute("percepcion", String.valueOf(this.percepcion));
        jugador.setAttribute("inteligencia", String.valueOf(this.inteligencia));
        jugador.setAttribute("astucia", String.valueOf(this.astucia));
        jugador.setAttribute("disciplinas", this.disciplinas);
        jugador.setAttribute("virtudes", this.virtudes);
        jugador.setAttribute("defectos", this.defectos);




        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {

            transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            File sdcard = Environment.getExternalStorageDirectory();
            StreamResult result = new StreamResult(new File(sdcard.getAbsolutePath()+"/media/"+this.nombre+".xml"));

            transformer.transform(source, result);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    /**
     * Constructor de jugador que lee del fichero xml
     * @param nombre
     */
    public Jugador(String nombre){
        File sdcard = Environment.getExternalStorageDirectory();
        File fXmlFile = new File(nombre);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            Element player= (Element) doc.getElementsByTagName("Jugador").item(0);
            this.nombre=player.getAttribute("nombre");
            this.jugador=player.getAttribute("jugador");
            this.sexo=player.getAttribute("sexo");
            this.raza=player.getAttribute("raza");
            this.clase=player.getAttribute("clase");
            this.partida=player.getAttribute("partida");
            this.disciplinas= player.getAttribute("disciplinas");
            this.virtudes= player.getAttribute("virtudes");
            this.defectos= player.getAttribute("defectos");
            this.vit=Integer.parseInt(player.getAttribute("vit"));
            this.exp=Integer.parseInt(player.getAttribute("exp"));
            this.percepcion=Integer.parseInt(player.getAttribute("percepcion"));
            this.inteligencia=Integer.parseInt(player.getAttribute("inteligencia"));
            this.astucia=Integer.parseInt(player.getAttribute("astucia"));
            this.carisma=Integer.parseInt(player.getAttribute("carisma"));
            this.resistencia=Integer.parseInt(player.getAttribute("resistencia"));
            this.apariencia=Integer.parseInt(player.getAttribute("apariencia"));
            this.manipulacion=Integer.parseInt(player.getAttribute("manipulacion"));
            this.destreza=Integer.parseInt(player.getAttribute("destreza"));
            this.fuerza=Integer.parseInt(player.getAttribute("fuerza"));
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

}
