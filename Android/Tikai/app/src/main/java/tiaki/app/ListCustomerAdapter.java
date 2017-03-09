package tiaki.app;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import controller.Controller;
import model.Customer;

public class ListCustomerAdapter extends ArrayAdapter<Customer> {

    public ListCustomerAdapter(Context context, ArrayList<Customer> customers){
        super(context, 0, customers);
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        Context cont = getContext();
        Object sys = cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = (LayoutInflater) sys;

        if (view == null) {
            view = inflater.inflate(R.layout.list_item_customer, parent, false);
        }

        TextView name = (TextView) view.findViewById(R.id.residency_name);
        TextView id = (TextView) view.findViewById(R.id.residency_id);
        TextView address = (TextView) view.findViewById(R.id.residency_address);
        ImageView buttonDelete = (ImageView) view.findViewById(R.id.button_delete_customer);
        ImageView buttonUpdate = (ImageView) view.findViewById(R.id.button_update_customer);

        final Customer customer = getItem(position);
        name.setText(customer.getName());
        id.setText(String.valueOf(customer.getId()));
        address.setText(customer.getAddress());

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.confirm_dialog);
                dialog.setTitle(R.string.text_delete);

                Button buttonConfirm = (Button) dialog.findViewById(R.id.button_confirm);
                buttonConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Controller.getInstance().getMCustomers().delete(customer);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });

                Button buttonCancel = (Button) dialog.findViewById(R.id.button_cancel);
                buttonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.list_add_customer);
                dialog.setTitle(R.string.text_update);

                EditText textId = (EditText) dialog.findViewById(R.id.add_edit_text_customer_id);
                final EditText textName = (EditText) dialog.findViewById(R.id.add_edit_text_customer_name);
                final EditText textAddress = (EditText) dialog.findViewById(R.id.add_edit_text_customer_address);
                Button buttonCommit = (Button) dialog.findViewById(R.id.add_button_customer_commit);

                textId.setKeyListener(null);
                textId.setText(String.valueOf(customer.getId()));
                textName.setText(customer.getName());
                textAddress.setText(customer.getAddress());

                buttonCommit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Customer edited = new Customer(customer.getId());
                        edited.setName(textName.getText().toString());
                        edited.setAddress(textAddress.getText().toString());
                        Controller.getInstance().getMCustomers().createOrUpdate(edited);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }

        });

        return view;
    }
}
