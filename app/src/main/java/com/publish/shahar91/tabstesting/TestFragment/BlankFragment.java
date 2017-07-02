package com.publish.shahar91.tabstesting.TestFragment;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.publish.shahar91.tabstesting.R;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import me.sargunvohra.lib.pokekotlin.model.Type;
import me.sargunvohra.lib.pokekotlin.model.TypeRelations;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Context context = getContext();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ProgressBar prog;
    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        prog = (ProgressBar) view.findViewById(R.id.progress);

        prog.setVisibility(View.INVISIBLE);
        PokeAsyncTask task = new PokeAsyncTask();
        task.execute();

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    private void updateUi(String s) {
        TextView first = (TextView) getActivity().findViewById(R.id.firstText);
        first.setText(s);
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
        void onFragmentInteraction(Uri uri);
    }

    private class PokeAsyncTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            PokeApi pokeApi = new PokeApiClient();

////          returns NamedApiResource(name=beedrill-mega, category=pokemon, id=10090) last item, mega's ARE in the list
//
//            NamedApiResourceList namedApiResource = pokeApi.getPokemonList(0, 1000);
//            List<NamedApiResource> arrayList = namedApiResource.getResults();
//            Log.v("CHARIZARD", arrayList.get(810).toString());
//
//

////          returns NamedApiResource(name=volcanion, category=pokemon-species, id=721) last item, NO mega's in this list
//            NamedApiResourceList namedApiResource = pokeApi.getPokemonSpeciesList(0, 1000);
//            List<NamedApiResource> arrayList = namedApiResource.getResults();
//            Log.v("CHARIZARD", arrayList.get(720).toString());

////            returns NamedApiResource(name=fighting, category=type, id=2)
//            NamedApiResourceList namedApiResource = pokeApi.getTypeList(0, 1000);
//            List<NamedApiResource> arrayList = namedApiResource.getResults();
//            Log.v("CHARIZARD", arrayList.get(1).toString());

            NamedApiResourceList types = pokeApi.getTypeList(0, 50);

            Log.v("TYPES", types.toString());

//
//            Type namedApiResource = pokeApi.getType(1);
//            TypeRelations relations = namedApiResource.getDamageRelations();
//            String test = pokeApi.getType(1).getDamageRelations().toString();
//
//
//            Log.v("CHARIZARD", test);


            return "";


        }

        @Override
        protected void onPostExecute(String s) {
            if (s.isEmpty()) {
                return;
            }


            updateUi(s);
        }
    }
}
