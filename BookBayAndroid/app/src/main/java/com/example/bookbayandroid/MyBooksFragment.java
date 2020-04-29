package com.example.bookbayandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bookbayandroid.AddBook;
import com.example.bookbayandroid.BackgroundWorker;
import com.example.bookbayandroid.CustomAdapterMyBooks;
import com.example.bookbayandroid.MyBooksData;
import com.example.bookbayandroid.NavDrawer;
import com.example.bookbayandroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import static android.content.Context.MODE_PRIVATE;


public class MyBooksFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_mybooks, container, false);

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent addbookIntent = new Intent(view.getContext(), AddBook.class);
                view.getContext().startActivity(addbookIntent);
            }
        });

        SharedPreferences sp1=getContext().getSharedPreferences("userdetails", MODE_PRIVATE);
        String username=sp1.getString("username", null);

        String type = "mybooks";
        BackgroundWorker backgroundWorker = new BackgroundWorker(getContext());
        try {
            String str_result = backgroundWorker.execute(type,username).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String books=sp1.getString("mybooks", null);
        if(books.equals("No Book Added!")){

        }
        else {
            String[] book = books.split(";");
            final ListView list = root.findViewById(R.id.list);
            ArrayList<MyBooksData> arrayList = new ArrayList<MyBooksData>();
            int i;
            for(i=0;i<book.length;i++){
                String[] params = book[i].split(":");
                arrayList.add(new MyBooksData(params[7], params[9],params[5],params[8],params[10],params[1]));
            }
            CustomAdapterMyBooks customAdapter = new CustomAdapterMyBooks(root.getContext(), arrayList);
            list.setAdapter(customAdapter);
        }

        return root;
    }
}
