package br.edu.ifpb.adapter;

import java.util.List;

import res.layout.*;
import com.example.exemplotw.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.edu.ifpb.entidade.Pessoa;

public class PessoasCustomAdapter extends BaseAdapter {

	Context context;

    List<Pessoa> pessoas;
     
    public PessoasCustomAdapter(Context context, List<Pessoa> pessoas) {
        this.context = context;
        this.pessoas = pessoas;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
         
        LayoutInflater mInflater = (LayoutInflater)  context.getSystemService(
                Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            convertView = mInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.txtInscription = (TextView) convertView.findViewById(R.id.inscription);
            holder.txtFullName = (TextView) convertView.findViewById(R.id.fullName);
            holder.txtEmail = (TextView) convertView.findViewById(R.id.email);
            holder.txtEntregue = (TextView) convertView.findViewById(R.id.entregue);
                        

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        Pessoa pessoaItem = (Pessoa) getItem(position);

        holder.txtFullName.setText(pessoaItem.getNome());
        holder.txtInscription.setText(pessoaItem.getInscription());
        holder.txtEmail.setText(pessoaItem.getEmail());
        holder.txtEntregue.setEnabled(pessoaItem.getEntregue());
        
        return convertView;
    }
 
    public int getCount() {     
        return pessoas.size();
    }
 
    public Object getItem(int position) {
        return pessoas.get(position);
    }
 
    public long getItemId(int position) {
        return pessoas.indexOf(getItem(position));
    }

    private class ViewHolder {

        TextView txtFullName;
        TextView txtInscription;
        TextView txtEmail;
        TextView txtEntregue;
    }
}