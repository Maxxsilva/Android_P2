package com.example.laboratorio06;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * 
 * @author Mauro Silva
 * 
 * Classe Activity Adaptador de imagens 
 *
 */


@SuppressWarnings("deprecation")
public class AdaptadorImagens extends BaseAdapter {
	
	int itensMinhaGaleria;
	Context contexto;
	
	private Integer[] minhasIdsImagens = {
			R.drawable.moto1,
			R.drawable.moto2,
			R.drawable.moto3
	};
	
	public AdaptadorImagens(Context contextoParam) {
		contexto = contextoParam;
		TypedArray atributos = contexto.obtainStyledAttributes(R.styleable.MinhaGaleria);
		itensMinhaGaleria = atributos.getResourceId(R.styleable.MinhaGaleria_android_galleryItemBackground, 0);
		atributos.recycle();
	}
	
	
	@Override
	public int getCount() {
		return minhasIdsImagens.length;
	}

	@Override
	public Object getItem(int position) {	
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imagem = new ImageView(contexto);
		
		imagem.setImageResource(minhasIdsImagens[position]);
		imagem.setLayoutParams(new Gallery.LayoutParams(150, 100));
		imagem.setScaleType(ImageView.ScaleType.FIT_XY);
		imagem.setBackgroundResource(itensMinhaGaleria);
		
		return imagem;
	}

}
