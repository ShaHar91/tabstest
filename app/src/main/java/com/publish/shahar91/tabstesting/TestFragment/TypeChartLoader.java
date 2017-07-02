package com.publish.shahar91.tabstesting.TestFragment;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.CursorLoader;


import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.TypeRelations;

/**
 * Created by Christiano on 2/07/2017.
 */

public class TypeChartLoader extends AsyncTaskLoader<TypeRelations> {
    int type;

    public TypeChartLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }


    @Override
    public TypeRelations loadInBackground() {
        Context context = this.getContext();
        PokeApi pokeApi = new PokeApiClient();
//        String doubleDam = pokeApi.getType(0).getDamageRelations().getDoubleDamageFrom().toString();
//        String halfDam = pokeApi.getType(0).getDamageRelations().getHalfDamageFrom().toString();
//        String noDam = pokeApi.getType(0).getDamageRelations().getNoDamageFrom().toString();
        TypeRelations relation = pokeApi.getType(5).getDamageRelations();

        return relation;

    }
}
