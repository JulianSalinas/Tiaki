package tiaki.app;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import controller.MCustomers;
import controller.Controller;
import model.Customer;

public class ListCustomerFragment extends Fragment implements ListView.OnItemClickListener, Button.OnClickListener{

    private MCustomers mCustomers;
    private ListCustomerAdapter adapter;
    private ListView list;
    private Button button;

    public ListCustomerFragment() {
        mCustomers = Controller.getInstance().getMCustomers();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.list_fragment_customer, container, false);
        adapter = new ListCustomerAdapter(getActivity(), mCustomers.consult());
        button = (Button) view.findViewById(R.id.button_add_customer);
        button.setOnClickListener(this);
        list = (ListView) view.findViewById(R.id.customers_list);
        list.setOnItemClickListener(this);
        list.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        view.setBackgroundColor(getResources().getColor(R.color.flatui_green_sea));
    }

    @Override
    public void onClick(View v) {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.list_add_customer);
        dialog.setTitle(R.string.text_create);

        final EditText textId = (EditText) dialog.findViewById(R.id.add_edit_text_customer_id);
        final EditText textName = (EditText) dialog.findViewById(R.id.add_edit_text_customer_name);
        final EditText textAddress = (EditText) dialog.findViewById(R.id.add_edit_text_customer_address);
        final Button buttonCommit = (Button) dialog.findViewById(R.id.add_button_customer_commit);

        buttonCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(textId.getText().toString());
                String name = String.valueOf(textName.getText());
                String address = String.valueOf(textAddress.getText());

                final Customer customer = new Customer(id, name, address);
                Controller.getInstance().getMCustomers().createOrUpdate(customer);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
