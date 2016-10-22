package com.tarantino.ocean.tarantino5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.oceanbrasil.libocean.Ocean;
import com.oceanbrasil.libocean.control.http.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Request.RequestListener {

    private ArrayList<Filme> filmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ocean.newRequest("https://gist.githubusercontent.com/rst2trindade/b043e2352470ee7dbf1ab371f29bb877/raw/104095d03762c88a9183979fdd5d3da20e2f16b3/tarantino.json",this).get().send();
    }

    @Override
    public void onRequestOk(String resposta, JSONObject jsonObject, int code)
    {
        if(code == Request.NENHUM_ERROR)
        {
           // ArrayList<Filme> filmes = stringtoGson(s);
            //criarAdapter(filmes);

            ArrayList<Filme> filmes = new ArrayList<>();
            if(resposta!=null)
            {
                try
                {
                    JSONArray object = new JSONArray(resposta);

                    for (int i=0; i<object.length();i++)
                    {
                        JSONObject filme = object.getJSONObject(i);
                        String capa = filme.getString("poster");
                        String titulo = filme.getString("show_title");
                        String atores = filme.getString("show_cast");
                        int ano = filme.getInt("release_year");
                        int tempo = filme.getInt("runtime");

                        Log.d("DebugPaginas",""+tempo);
                        Log.d("DebugAno",""+ano);
                        Log.d("DebugTitulo",titulo);
                        Log.d("DebugAutor",atores);
                        Log.d("DebugCapa",capa);

                        Filme f = new Filme(capa,titulo,atores,ano,tempo);
                        filmes.add(f);
                    }

                    criarAdapter(filmes);
                }

                catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }

        }

    }

    private ArrayList<Filme> stringtoGson(String resposta)
    {
        ArrayList<Filme> filmes = new ArrayList<>();
        if(resposta!=null)
        {
            try
            {
                JSONArray object = new JSONArray(resposta);

                for (int i=0; i<object.length();i++)
                {
                    JSONObject filme = object.getJSONObject(i);
                    String capa = filme.getString("poster");
                    String titulo = filme.getString("show_title");
                    String atores = filme.getString("show_cast");
                    int ano = filme.getInt("release_year");
                    int tempo = filme.getInt("runtime");

                    Filme f = new Filme(capa,titulo,atores,ano,tempo);
                    filmes.add(f);
                }
            }

            catch (JSONException e)
            {
                e.printStackTrace();
            }


        }



        return filmes;
    }

    private void criarAdapter(ArrayList<Filme> f)
    {
        filmes = f;

        MyAdapter adapter = new MyAdapter(this,f);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lista);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        esconderProgressbar(f);

    }

    private void esconderProgressbar(ArrayList<Filme> f)
    {
        if(f.size() > 0)
        {
            // Sumir o progressBar
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.loading);
            progressBar.setVisibility(View.GONE);
        }

    }
}
