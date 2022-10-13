package cbtis.app.aplicacionCbtis.ui.comunidad.controlador;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.Duration;

import cbtis.app.aplicacionCbtis.R;


public class EspecialidadesFragment extends Fragment {
    private TextView textContabilidad;
    private TextView textLaboratorio;
    private TextView textOfimatica;
    private TextView textMecanica;
    private String descripcionContabilidad = "Realizar los tramites de las operaciones fiscales (pago de impuestos).\n \n" +
            "Determinar el pago, retención de obligaciones fiscales (Impuestos).\n\n" +
            "Desempeñar puestos de auxiliar contable, auxiliar administrativo, auxiliar de credito y cobranza, auxiliar de nomina, auxiliar de auditoria y auxiliar de finanzas.\n\n" +
            "Al termino de sus estudios podrá incorporarse en instituciones como: Bancos, Cajas populares, Despachos, Empresas de Gobierno y Particulares.";

    private String descripcionLaboratorio = "Aplicar los métodos técnicas y manejo de aparatos de un laboratorio clínico, microbiólogo, bioquimico, etc.\n" +
            "\n" +
            "Obtener diferentes tipos de muestras del cuerpo humano como:         \n" +
            "\n" +
            "Aplicar las normas vigentes para cumplir el reglamento del sector salud. \n \n" + "Esta capasitado además para continuar sus estudios universitarios en carreras acordes como: Medicina, Biólogo, Veterinario, Odontología, etc.";
    private String descripcionOfimatica = "En este sentido aplicará los principios de la informática de una organización realizando documentos electrónicos, aplicando sistemas básicos de información, diseña y gestiona bases de datos.\n" +
            "\n" +
            "Así mismo con amplio conocimiento y actitud de liderazgo, contará con habilidad para establecer relaciones interpersonales y con el medio ambiente; esta orientación se dará a través del componente profesional.";
    private String descripcionMecanica = "operar máquinas de soldar para la aplicación de diversas soldaduras y realizar trabajos de banco pata ajustar piezas mecánicas utilizando herramientas de corte manuales de uso común e instrumentos de medición para el logro de un proyecto especifico siguiendo procedimientos, instrucciones y normas de seguridad.\n" +
            "\n" +
            "Programar y llevar a cabo el manejo de la máquinaria industrial, aplicando sus conocimientos con un ampliio sentido de responsabilidad.\n" +
            "\n" +
            "Desempeñar funciones de supervición, operación e instalación de máquinas de producción de bienes capital.\n" +
            "\n" +
            "Planificar, organizar y supervisar los procesos de detección de fallas mecánicas aplicando principios tecnológicos básicos para realizar el mantenimiento preventivo de la maquinaria industrial.";


    public EspecialidadesFragment() {
        // Required empty public constructor
    }

    public static EspecialidadesFragment newInstance() {
        EspecialidadesFragment fragment = new EspecialidadesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_especialidades, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textContabilidad = view.findViewById(R.id.textoContabilidad);
        textLaboratorio = view.findViewById(R.id.textoLaboratorio);
        textOfimatica = view.findViewById(R.id.textoOfimatica);
        textMecanica = view.findViewById(R.id.textoMecanica);

        textEspecialidad(textContabilidad, descripcionContabilidad);
        textEspecialidad(textLaboratorio, descripcionLaboratorio);
        textEspecialidad(textOfimatica, descripcionOfimatica);
        textEspecialidad(textMecanica, descripcionMecanica);
    }

    public void textEspecialidad(TextView textView, String descripcion){
        textView.setText(descripcion);
    }
}