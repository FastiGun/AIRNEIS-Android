package com.example.airneis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentLegalNotices extends Fragment {

    WebView webView_LegalNotices;
    RedirectionInterface redirectionInterface;

    public FragmentLegalNotices(RedirectionInterface listener) {
        this.redirectionInterface = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_legal_notices, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webView_LegalNotices = view.findViewById(R.id.webView_legalNotices);
        webView_LegalNotices.getSettings().setJavaScriptEnabled(true);
        webView_LegalNotices.loadUrl("https://docs.google.com/gview?embedded=true&url=" + "https://airneis-junia.vercel.app/assets/file/MentionsLegales.pdf");


    }
}
