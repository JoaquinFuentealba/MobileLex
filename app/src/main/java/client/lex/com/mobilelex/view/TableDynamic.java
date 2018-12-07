package client.lex.com.mobilelex.view;

import android.content.Context;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import client.lex.com.mobilelex.domain.Constante;

public class TableDynamic {

    private TableLayout tableLayout;
    private Context context;
    private String [] header;
    private ArrayList<String[]> data;
    private TableRow tableRow;
    private TextView txtCell;
    private int indexCell;
    private int indexRow;

    public TableDynamic(TableLayout tableLayout, Context context) {
        this.context=context;
        this.tableLayout=tableLayout;
    }

    public  void addHeader(String [] header){
        this.header = header;
        createHeader();
    }
    public void addData(ArrayList<String[]> data){
        this.data= data;
        createDataTable();
    }
    private void newRow(){
        tableRow = new TableRow(context);

    }
    private void newcell(){
        txtCell= new TextView(context);
        txtCell.setGravity(Gravity.CENTER);
        txtCell.setTextSize(25);
    }
    private void createHeader(){
        indexCell=0;
        newRow();
        while(indexCell<header.length){
            newcell();
            txtCell.setText(header[indexCell++]);
            tableRow.addView(txtCell,newTableRowParams());
        }
        tableLayout.addView(tableRow,newTableRowParams());
    }

    private void createDataTable(){
        String info;
        for(indexRow=1;indexRow<=header.length;indexRow++){
            newRow();
            for(indexCell =0;indexCell < header.length;indexCell++){
                newcell();
                String[] colums = data.get(indexRow -1);
                info=(indexCell<colums.length)?colums[indexCell]:"";
                txtCell.setText(info);
                tableRow.addView(txtCell,newTableRowParams());
            }
            tableLayout.addView(tableRow);
        }
    }

    private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(2,2,2,2);
        params.weight=1;
        return params;
    }
}
