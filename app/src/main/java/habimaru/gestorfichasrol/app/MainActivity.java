package habimaru.gestorfichasrol.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.net.URI;

/**
 * Esta pequeña aplicación es un buen ejemplo de cómo cargar y guardar archivos .xml para mantener
 * fichas de usuario
 */
public class MainActivity extends Activity {
    Jugador jug;
    private static final int ABRIRFICHERO_RESULT_CODE = 1, GUARDARFICHERO_RESULT_CODE=2;
    private String rutaActiva="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jug = new Jugador();
        imprJugador(jug);
    }

    /**
     * Este método imprime el jugador determinado por pantalla en función de sus parámetros
     * @param jug
     */
    public void imprJugador(Jugador jug){
        EditText e = (EditText) findViewById(R.id.campoNombre);
        e.setText(jug.nombre);
        e = (EditText) findViewById(R.id.campoJugador);
        e.setText(jug.jugador);
        e = (EditText) findViewById(R.id.campoJugador);
        e.setText(jug.jugador);
        e = (EditText) findViewById(R.id.campoVit);
        e.setText(String.valueOf(jug.vit));
        e = (EditText) findViewById(R.id.campoExp);
        e.setText(String.valueOf(jug.exp));
        e = (EditText) findViewById(R.id.campoPartida);
        e.setText(jug.partida);
        e = (EditText) findViewById(R.id.campoRaza);
        e.setText(jug.raza);
        e = (EditText) findViewById(R.id.campoSexo);
        e.setText(jug.sexo);
        e = (EditText) findViewById(R.id.campoClase);
        e.setText(jug.clase);
        TextView t = (TextView) findViewById(R.id.campoDisciplinas);
        t.setText(jug.disciplinas);
        t = (TextView) findViewById(R.id.campoVirtudes);
        t.setText(jug.virtudes);
        t = (TextView) findViewById(R.id.campoDefectos);
        t.setText(jug.defectos);
        RatingBar s = (RatingBar) findViewById(R.id.stFuerza);
        s.setProgress(jug.fuerza);
        s = (RatingBar) findViewById(R.id.stDestreza);
        s.setProgress(jug.destreza);
        s = (RatingBar) findViewById(R.id.stResistencia);
        s.setProgress(jug.resistencia);
        s = (RatingBar) findViewById(R.id.stCarisma);
        s.setProgress(jug.carisma);
        s = (RatingBar) findViewById(R.id.stManipulacion);
        s.setProgress(jug.manipulacion);
        s = (RatingBar) findViewById(R.id.stApariencia);
        s.setProgress(jug.apariencia);
        s = (RatingBar) findViewById(R.id.stPercepcion);
        s.setProgress(jug.percepcion);
        s = (RatingBar) findViewById(R.id.stInteligencia);
        s.setProgress(jug.inteligencia);
        s = (RatingBar) findViewById(R.id.stAstucia);
        s.setProgress(jug.astucia);

    }

    /**
     * El método cargarJugador, dada una ruta del xml, lo carga
     * @param ruta
     */
    public void cargarJugador(String ruta){
        jug = new Jugador(ruta);
        imprJugador(jug);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Selección de opciones. La opción guardar serializa el objeto en un xml y la de cargar
     * se hace con uno.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_guardar) {

            EditText e = (EditText) findViewById(R.id.campoNombre);
            jug.nombre = e.getText().toString();
            e = (EditText) findViewById(R.id.campoJugador);
            jug.jugador = e.getText().toString();
            e = (EditText) findViewById(R.id.campoVit);
            jug.vit = Integer.parseInt(e.getText().toString());
            e = (EditText) findViewById(R.id.campoExp);
            jug.exp = Integer.parseInt(e.getText().toString());
            e = (EditText) findViewById(R.id.campoPartida);
            jug.partida = e.getText().toString();
            e = (EditText) findViewById(R.id.campoRaza);
            jug.raza = e.getText().toString();
            e = (EditText) findViewById(R.id.campoSexo);
            jug.sexo = e.getText().toString();            e = (EditText) findViewById(R.id.campoClase);
            e.setText(jug.clase);
            TextView t = (TextView) findViewById(R.id.campoDisciplinas);
            jug.disciplinas = t.getText().toString();
            t = (TextView) findViewById(R.id.campoVirtudes);
            jug.virtudes = t.getText().toString();
            t = (TextView) findViewById(R.id.campoDefectos);
            jug.defectos = t.getText().toString();
            RatingBar s = (RatingBar) findViewById(R.id.stFuerza);
            jug.fuerza=(int)s.getRating();
            s = (RatingBar) findViewById(R.id.stDestreza);
            jug.destreza=(int)s.getRating();
            s = (RatingBar) findViewById(R.id.stResistencia);
            jug.resistencia=(int)s.getRating();
            s = (RatingBar) findViewById(R.id.stApariencia);
            jug.apariencia=(int)s.getRating();
            s = (RatingBar) findViewById(R.id.stAstucia);
            jug.astucia=(int)s.getRating();
            s = (RatingBar) findViewById(R.id.stCarisma);
            jug.carisma=(int)s.getRating();
            s = (RatingBar) findViewById(R.id.stInteligencia);
            jug.inteligencia=(int)s.getRating();
            s = (RatingBar) findViewById(R.id.stManipulacion);
            jug.manipulacion=(int)s.getRating();
            s = (RatingBar) findViewById(R.id.stPercepcion);
            jug.percepcion=(int)s.getRating();
            this.jug.toXML();


            return true;
        }
        if (id == R.id.action_cargar) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("file/*.xml");
            startActivityForResult(intent, ABRIRFICHERO_RESULT_CODE);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ABRIRFICHERO_RESULT_CODE:
                if (resultCode == RESULT_OK) {

                    // Mostramos por pantalla la ruta del archivo seleccionado.
                    String ruta = data.getData().getPath();
                    rutaActiva=ruta;
                    cargarJugador(rutaActiva);
                }
        }
    }


}
