package cbtis.app.aplicacionCbtis.ui.cursos.controlador;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cbtis.app.aplicacionCbtis.R;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterCursos.ListAdapter;
import cbtis.app.aplicacionCbtis.ui.cursos.adapterCursos.ListElementCursos;

public class CursosFragment extends Fragment implements RecyclerViewInterfaceCursos{
    private ListAdapter listAdapter;
    private List<ListElementCursos> listaElemento;

    public CursosFragment() {
        // Required empty public constructor
    }

    public static CursosFragment newInstance(String param1, String param2) {
        CursosFragment fragment = new CursosFragment();
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
        return inflater.inflate(R.layout.fragment_cursos2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.listaElemento = new ArrayList<>();

        //CURSOS DE MATEMATICAS
        this.listaElemento.add(new ListElementCursos(R.drawable.cursoderivadas, "Bases Matemáticas: Derivadas", "EDX Course", "Curso básico sobre funciones y sus derivadas, incluyendo sus aplicaciones a la resolución de problemas.", "https://www.edx.org/course/bases-matematicas-derivadas?index=product_value_experiment_a&queryID=b870d44622b23b65e47f618d2f1c90e1&position=4"));
        //algebra
        this.listaElemento.add(new ListElementCursos(R.drawable.algebra1, "Álgebra 1", "Khan Academy", "Curso de álgebra que abarca los temas de ecuaciones lineales, desigualdades, funciones y gráficas.", "https://es.khanacademy.org/math/algebra"));
        this.listaElemento.add(new ListElementCursos(R.drawable.algebra, "Álgebra 2", "Khan Academy", "Curso de álgebra 2 que cubre polinomios, números complejos, exponentes racionales, funciones exponenciales y logarítmicas.", "https://es.khanacademy.org/math/algebra2"));
        this.listaElemento.add(new ListElementCursos(R.drawable.algebra_linear, "Álgebra lineal", "Khan Academy", "Aprende álgebra lineal: vectores, matrices, transformaciones y más.", "https://es.khanacademy.org/math/linear-algebra"));
        this.listaElemento.add(new ListElementCursos(R.drawable.algebra_todocontenido, "Álgebra (todo el contenido)", "Khan Academy", "Introducción al álgebra · Resolución de ecuaciones básicas y desigualdades (una variable, lineal) · Ecuaciones lineales, funciones y gráficas · Sucesiones.", "https://es.khanacademy.org/math/algebra-home"));
        //geometria
        this.listaElemento.add(new ListElementCursos(R.drawable.geometriaytrigonometria, "Geometría y Trigonometria", "Teachlr", "ADQUIRIR CONOCIMIENTOS BÁSICOS Y PRÁCTICOS DE GEOMETRÍA Y TRIGONOMETRIA.", "https://teachlr.com/cursos-online/geometria-y-trigonometria/"));
        this.listaElemento.add(new ListElementCursos(R.drawable.geometria_analitica, "Geometría analítica", "Khan Academy", "La geometría analítica relaciona figuras geométricas con el plano coordenado y sus representaciones algebraicas.", "https://es.khanacademy.org/math/geometry/hs-geo-analytic-geometry"));
        //calculo
        this.listaElemento.add(new ListElementCursos(R.drawable.calculodiferencias, "Cálculo diferencial", "Khan Academy", " El cálculo diferencial se ocupa del estudio de las razones a las cuales cambian ciertas cantidades, y es una de las dos áreas principales del cálculo (la otra es el cálculo integral).", "https://es.khanacademy.org/math/differential-calculus"));
        this.listaElemento.add(new ListElementCursos(R.drawable.calculointegral, "Cálculo integral", "Khan Academy", "Aprende cálculo integral: Integrales indefinidas, sumas de Riemann, integrales definidas, problemas de aplicación y mucho más.", "https://es.khanacademy.org/math/integral-calculus"));
        this.listaElemento.add(new ListElementCursos(R.drawable.calculo_multivariable, "Cálculo multivariable", "Khan Academy", "Aprende cálculo multivariable: derivadas e integrales de funciones multivariables, problemas de aplicaciones y más.", "https://es.khanacademy.org/math/multivariable-calculus"));
        this.listaElemento.add(new ListElementCursos(R.drawable.calculo_avanzado1, "Cálculo avanzado 1", "Khan Academy", "todo lo que necesitas saber sobre límites, derivadas e integrales para pasar el examen de AP® (Advanced Placement).", "https://es.khanacademy.org/math/ap-calculus-ab"));
        this.listaElemento.add(new ListElementCursos(R.drawable.calculo_avanzado2, "Cálculo avanzado 2", "Khan Academy", "Cálculo avanzado 2 (AP Calculus BC) · Resumen de curso · Límites y continuidad · Diferenciación: definición y reglas básicas de las derivadas · Diferenciación, etc.", "https://es.khanacademy.org/math/ap-calculus-bc"));
        //probabilidad y estadistica
        this.listaElemento.add(new ListElementCursos(R.drawable.probabilidad_estadistica, "Estadística y probabilidad", "Coursera", "el curso busca ayudarte a que adquieras los aprendizajes que comprenden temas de estadística descriptiva, datos bivariados y probabilidad, los cuales te serán de utilidad en tu paso por la licenciatura y en tu vida profesional.", "https://mx.coursera.org/learn/estadistica-probabilidad?action=enroll"));

        this.listaElemento.add(new ListElementCursos(R.drawable.inglesbasic, "Inglés para todos: nivel básico", "EDX", "English for everyone: basics es un curso URosarioX  enfocado en el aprendizaje de inglés desde las expresiones y estructuras más básicas.", "https://www.edx.org/es/course/ingles-para-todos-nivel-basico?index=spanish_product&queryID=5a2f9b5b46defecee8366c178122b812&position=1"));

        this.listaElemento.add(new ListElementCursos(R.drawable.fisica_universitaria, "Física Universitaria", "Coursera", "Este curso provee al estudiante con conceptos y herramientas matemáticas para modelar problemas en física, que al aplicar podrá enfrentar con éxito los cursos de física universitarios.", "https://mx.coursera.org/learn/fisica-universitaria?action=enroll&courseSlug=fisica-universitaria&showOnboardingModal=check"));

        this.listaElemento.add(new ListElementCursos(R.drawable.cursopython, "Automatización de TI de Google con Python", "Coursera", "Aprenda habilidades en demanda como Python, Git y automatización de TI para avanzar en su carrera", "https://www.coursera.org/professional-certificates/google-it-automation"));





        ListAdapter listAdapter = new ListAdapter(this.listaElemento, getContext(), this);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_cursos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);

    }

    @Override
    public void onItemClick(int position) {
        String urlCurso = this.listaElemento.get(position).getUrlCurso();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlCurso));
        startActivity(intent);
    }
}