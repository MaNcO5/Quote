package com.example.manco.myapplication.Runnable;

import android.widget.TextView;

import com.example.manco.myapplication.Entity.Quote;
import com.example.manco.myapplication.HttpController.CustomRunnable;
import com.example.manco.myapplication.TextUtils.TextViewSpan;


public class QuoteRunnable extends CustomRunnable{
    private TextView authorTextView, quoteTextView;

    public QuoteRunnable (TextView authorTextView, TextView quoteTextView) {
        this.authorTextView = authorTextView;
        this.quoteTextView = quoteTextView;
    }

    @Override
    public void run() {
        String author = ((Quote)this.data).getAuthor();
        String quote = ((Quote)this.data).getQuote();
        authorTextView.setText(author);
        //quoteTextView.setText(quote);
        TextViewSpan.work(quoteTextView, quote, -1);
    }
}
