package imagisoft.tiakisystem;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import controller.Controller;
import model.Customer;

public class AdapterCustomer extends ArrayAdapter<Customer> {

    private TextView id;
    private TextView name;
    private TextView address;
    private ImageView pic;
    private ImageView buttonDelete;
    private ImageView buttonUpdate;

    public AdapterCustomer(Context context, ArrayList<Customer> customers){
        super(context, 0, customers);
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        view = inflateView(view, parent);
        startAttributes(view);
        final Customer customer = getItem(position);
        setAttributes(customer);
        return view;
    }

    private View inflateView(View view, ViewGroup parent) {
        if (view == null) {
            Context c = getContext();
            Object i = c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LayoutInflater inflater = (LayoutInflater) i;
            view = inflater.inflate(R.layout.fragment_list_item, parent, false);
        }
        return view;
    }

    private void startAttributes(View view){
        name = (TextView) view.findViewById(R.id.field_1);
        id = (TextView) view.findViewById(R.id.field_2);
        address = (TextView) view.findViewById(R.id.field_3);
        pic = (ImageView) view.findViewById(R.id.pic);
        buttonDelete = (ImageView) view.findViewById(R.id.button_delete);
        buttonUpdate = (ImageView) view.findViewById(R.id.button_update);
    }

    private void setAttributes(final Customer customer){
        name.setText(customer.getName());
        id.setText(String.valueOf(customer.getId()));
        address.setText(customer.getAddress());
        pic.setImageResource(R.drawable.ic_home);

        buttonDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_confirmation);
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
                    public void onClick(View v) { dialog.dismiss(); }
                });

                dialog.show();
            }

        }); //Fin de buttonDelete

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_customer);
                dialog.setTitle(R.string.text_update);

                final EditText textId = (EditText) dialog.findViewById(R.id.add_edit_text_customer_id);
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

        }); // Fin de buttonUpdate

    }

}
