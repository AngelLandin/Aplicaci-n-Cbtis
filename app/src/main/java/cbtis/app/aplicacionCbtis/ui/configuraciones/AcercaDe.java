package cbtis.app.aplicacionCbtis.ui.configuraciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import cbtis.app.aplicacionCbtis.R;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        TextView textoContacto = findViewById(R.id.textoContacto);

        String texto = "<p><b>Número CBTis:</b> 412 157 2263 <br><b>Número CBTis:</b> 412 157 2297 <br><b>E-mail:</b> cbtis238.dir@dgeti.sems.god.mx <br> <b>E-mail:</b> escuelaactivaii@gmail.com </p>";
        Spanned spannedText = HtmlCompat.fromHtml(texto, HtmlCompat.FROM_HTML_MODE_LEGACY);
        textoContacto.setText(spannedText);

    }
}