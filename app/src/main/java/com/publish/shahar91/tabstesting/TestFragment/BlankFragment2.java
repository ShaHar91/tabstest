package com.publish.shahar91.tabstesting.TestFragment;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.publish.shahar91.tabstesting.R;

import java.util.List;

import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.TypeRelations;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment2 extends Fragment implements LoaderManager.LoaderCallbacks<TypeRelations> {
    private OnFragmentInteractionListener mListener;

    private Context context = getActivity();
    private static final int TYPE_RELATIONS = 0;
    private Cursor mData;

    private LinearLayout containerLl, containerNoPokes;
    private String type1Temp, type2Temp = "";
    private Spinner type1, type2;
    private TextView normalTv, fireTv, waterTv, electricTv, grassTv, iceTv, fightTv,
            poisonTv, groundTv, flyingTv, psychicTv, bugTv, rockTv, ghostTv,
            dragonTv, darkTv, steelTv, fairyTv, noPokes;

    private boolean isConnected;

    public BlankFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getLoaderManager().initLoader(0, null, this);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BlankFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment2 newInstance() {
        return new BlankFragment2();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.blank_fragment2, container, false);

//        ConnectivityManager cm = (ConnectivityManager) getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//
//        isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        containerLl = (LinearLayout) view.findViewById(R.id.containerLl);
        containerNoPokes = (LinearLayout) view.findViewById(R.id.containerNoPokes);

        type1 = (Spinner) view.findViewById(R.id.type1Sp);
        type2 = (Spinner) view.findViewById(R.id.type2Sp);

        normalTv = (TextView) view.findViewById(R.id.normalXTv);
        fireTv = (TextView) view.findViewById(R.id.fireXTv);
        waterTv = (TextView) view.findViewById(R.id.waterXTv);
        electricTv = (TextView) view.findViewById(R.id.electricXTv);
        grassTv = (TextView) view.findViewById(R.id.grassXTv);
        iceTv = (TextView) view.findViewById(R.id.iceXTv);
        fightTv = (TextView) view.findViewById(R.id.fightXTv);
        poisonTv = (TextView) view.findViewById(R.id.poisonXTv);
        groundTv = (TextView) view.findViewById(R.id.groundXTv);
        flyingTv = (TextView) view.findViewById(R.id.flyingXTv);
        psychicTv = (TextView) view.findViewById(R.id.psychicXTv);
        bugTv = (TextView) view.findViewById(R.id.bugXTv);
        rockTv = (TextView) view.findViewById(R.id.rockXTv);
        ghostTv = (TextView) view.findViewById(R.id.ghostXTv);
        dragonTv = (TextView) view.findViewById(R.id.dragonXTv);
        darkTv = (TextView) view.findViewById(R.id.darkXTv);
        steelTv = (TextView) view.findViewById(R.id.steelXTv);
        fairyTv = (TextView) view.findViewById(R.id.fairyXTv);

        type1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // Toast.makeText(com.ShaHar91.Pokedex.TypeChart.this,
                // type1.getSelectedItem().toString(), Toast.LENGTH_SHORT)
                // .show();

                type1Temp = type1.getSelectedItem().toString();
                if (type1Temp.isEmpty()) {
                    invisible();

                } else if (type1Temp.equals(type2Temp)) {
                    Toast.makeText(getActivity(),
                            "Please don't use the same types in both spinners",
                            Toast.LENGTH_SHORT).show();

                } else {
                    containerLl.setVisibility(View.VISIBLE);
                    getLoaderManager().initLoader(TYPE_RELATIONS, null, BlankFragment2.this);
//                    new LoadWeaknessTask().execute(type1Temp.toString(),
//                            type2Temp.toString());
//
//                    new LoadNoPokesTask().execute("", type1Temp.toString(),
//                            type2Temp.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        type2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                type2Temp = type2.getSelectedItem().toString();

                type1Temp = type1.getSelectedItem().toString();
                if (type1Temp.isEmpty()) {
                    invisible();

                } else if (type1Temp.equals(type2Temp)) {
                    Toast.makeText(getActivity(),
                            "Please don't use the same types in both spinners",
                            Toast.LENGTH_SHORT).show();
                } else {
                    containerLl.setVisibility(View.VISIBLE);
//
//                    new LoadWeaknessTask().execute(type1Temp.toString(),
//                            type2Temp.toString());
//
//                    new LoadNoPokesTask().execute("", type1Temp.toString(),
//                            type2Temp.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return view;
    }


//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    protected void invisible() {
        containerLl.setVisibility(View.INVISIBLE);
        containerNoPokes.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public Loader<TypeRelations> onCreateLoader(int id, Bundle args) {


        return new TypeChartLoader(getContext());
    }

    //returned ground type int 5
    @Override
    public void onLoadFinished(Loader<TypeRelations> loader, TypeRelations data) {
        StringBuilder builder = new StringBuilder();

        List<NamedApiResource> res = data.getDoubleDamageFrom();


        for (int i = 0; i < res.size(); i++) {
            builder.append(res.get(i).getName());
        }

        Log.v("TYPES_SINGLE", builder.toString());
        Log.v("TYPES", data.getDoubleDamageFrom().toString());


    }

    @Override
    public void onLoaderReset(Loader<TypeRelations> loader) {

    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
    }

}
