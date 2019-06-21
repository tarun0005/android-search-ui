package com.example.searchwidget.Builder;

import android.util.Log;

import com.example.searchwidget.Model.ClientSuggestionsModel;
import com.example.searchwidget.R;

import java.util.ArrayList;

public class DefaultClientSuggestions {

    ArrayList<String> suggestions;
    ArrayList<String> categories = null;
    ArrayList<Integer> searchIcon = null;
    ArrayList<Integer> trendingIcon = null;
    ArrayList<String> hits = null;

    /**
     * Builder for single suggestion entry
     *
     * @param suggestions List of suggestions
     */
    public DefaultClientSuggestions(ArrayList<String> suggestions) {
        this.suggestions = suggestions;
    }

    /**
     * Sets categories to be shown below search results
     *
     * @param categories List of categories
     * @return
     */
    public DefaultClientSuggestions setCategories(ArrayList<String> categories) {
        this.categories = categories;
        return this;
    }

    /**
     * Sets images or icons for suggestions
     *
     * @param searchIcon List of resource ids for each suggestion
     * @return
     */
    public DefaultClientSuggestions setSearchImages(ArrayList<Integer> searchIcon) {
        this.searchIcon = searchIcon;
        return this;
    }

    /**
     * Sets extra trending images or icons for suggestions - The rightmost icon
     *
     * @param trendingIcon List of resource ids for each suggestion
     * @return
     */
    public DefaultClientSuggestions setIcons(ArrayList<Integer> trendingIcon) {
        this.trendingIcon = trendingIcon;
        return this;
    }

    /**
     * Sets the hit count for each suggestion
     *
     * @param hits List of hits
     * @return
     */
    public DefaultClientSuggestions hits(ArrayList<String> hits) {
        this.hits = hits;
        return this;
    }

    /**
     * Binds all the parameter of Suggestion Builder and makes a list of SuggestionModel items
     *
     * @return List of items of SuggestionModel class
     */
    public ArrayList<ClientSuggestionsModel> build() {

        ArrayList<ClientSuggestionsModel> suggestions = new ArrayList<>();
        String category;
        String hit;
        int searchicon;
        int trendingicon;

        for(int i = 0; i < this.suggestions.size(); i++) {

            if(this.categories == null)
                category = null;
            else {
                if(this.categories.size() > i) {
                    category = this.categories.get(i);
                }
                else
                    category = null;
            }

            if(this.hits == null)
                hit = null;
            else {
                if(this.hits.size() > i) {
                    hit = this.hits.get(i);
                }
                else
                    hit = null;
            }

            if(this.searchIcon == null)
                searchicon = R.drawable.ic_search_icon;
            else {
                if(this.searchIcon.size() > i) {
                    searchicon = this.searchIcon.get(i);
                }
                else
                    searchicon = R.drawable.ic_search_icon;
            }

            if(this.trendingIcon == null)
                trendingicon = R.drawable.top_left_arrow;
            else {
                if(this.trendingIcon.size() > i) {
                    trendingicon = this.trendingIcon.get(i);
                }
                else
                    trendingicon = R.drawable.top_left_arrow;
            }

            suggestions.add(new ClientSuggestionsModel(this.suggestions.get(i),category, hit, searchicon, trendingicon ));
        }

        return suggestions;
    }
}
