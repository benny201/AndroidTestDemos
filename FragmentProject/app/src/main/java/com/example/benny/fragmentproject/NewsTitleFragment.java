package com.example.benny.fragmentproject;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benny on 16/11/19.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener{

    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;
    private static String TAG = "bennytest!!!!!!!!";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = getNews();
        adapter = new NewsAdapter(activity,R.layout.new_items,newsList);
        Log.d(TAG, "onAttach: done ");
        if(!newsList.isEmpty()) {
            Log.d(TAG, "onItemClick: not empty");
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        newsList = getNews();
        adapter = new NewsAdapter(context,R.layout.new_items,newsList);
        Log.d(TAG, "onAttachcontext: ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        newsTitleListView = (ListView) view.findViewById(R.id.title_list);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(this);
        Log.d(TAG, "onCreateView: done");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout)!=null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
        Log.d(TAG, "onActivityCreated: done");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        News news = newsList.get(position);

        if(isTwoPane) {

            NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refresh(news.getTitle(),news.getContent());
        } else {
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
        }
    }
    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }*/



    public List<News>getNews() {
        List<News> news = new ArrayList<>();
        News news1 = new News();
        news1.setTitle("Donald Trump offers Jeff Sessions attorney general post");
        news1.setContent("President-elect Trump has offered Alabama Sen. Jeff Sessions the post of attorney general, sources directly involved in the selection process tell CBS News.\n" +
                "\n" +
                "Sessions has been one of Mr. Trump’s closest and most consistent allies, and he was the first senator to announce his support for the president-elect. An architect of Mr. Trump’s immigration, counterterrorism and trade policies, Sessions was also considered for secretary of defense. The Trump transition team pronounced itself “unbelievably impressed” with Sessions in a statement, citing his work as a U.S. attorney and state attorney general in Alabama. Appointing him the nation’s top prosecutor is sure to be controversial, though.");
        news.add(news1);
        News news2 = new News();
        news2.setTitle("Facebook fake-news writer: ‘I think Donald Trump is in the White House because of me’");
        news2.setContent("What do the Amish lobby, gay wedding vans and the ban of the national anthem have in common? For starters, they’re all make-believe — and invented by the same man.\n" +
                "\n" +
                "Paul Horner, the 38-year-old impresario of a Facebook fake-news empire, has made his living off viral news hoaxes for several years. He has twice convinced the Internet that he’s British graffiti artist Banksy; he also published the very viral, very fake news of a Yelp vs. “South Park” lawsuit last year.");
        news.add(news2);
        return news;
    }
}
