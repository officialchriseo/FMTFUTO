package ng.com.blogspot.httpofficialceo.fmtfuto;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ng.com.blogspot.httpofficialceo.fmtfuto.adapter.ExpandableListAdapter;


/**
 * Created by official on 10/21/17.
 */

public class RatiosActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_ratios);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                final String selected = (String) listAdapter.getChild(groupPosition, childPosition);

                switch (selected) {
                    case "Gross Profit Rate":
                        Toast.makeText(RatiosActivity.this, "Gross Profit clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Return on Sales":
                        Toast.makeText(RatiosActivity.this, "Return on Sales clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Return on Assets":
                        Toast.makeText(RatiosActivity.this, "Return on Assets clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Return on Stockholder's Equity":
                        Toast.makeText(RatiosActivity.this, "Return on Stockholder\'s Equity clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Current Ratio":
                        Toast.makeText(RatiosActivity.this, "Current Ratio clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Acid Test Ratio":
                        Toast.makeText(RatiosActivity.this, "Acid Test Ratio clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Cash Ratio":
                        Toast.makeText(RatiosActivity.this, "Cash Ratio clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Net Working Ratio":
                        Toast.makeText(RatiosActivity.this, "Net Working Ratio clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Receivable Turnover":
                        Toast.makeText(RatiosActivity.this, "Receivable Turnover clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Days Sales Outstanding":
                        Toast.makeText(RatiosActivity.this, "Days Sales Outstanding clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Inventory Turnover":
                        Toast.makeText(RatiosActivity.this, "Inventory Turnover clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Days Inventory Outstanding":
                        Toast.makeText(RatiosActivity.this, "Days Inventory Outstanding clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Accounts Payable Outstanding":
                        Toast.makeText(RatiosActivity.this, "Accounts Payable Turnover clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Days Payable Outstanding":
                        Toast.makeText(RatiosActivity.this, "Days Payable Outstanding clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Operating Cycle":
                        Toast.makeText(RatiosActivity.this, "Operating Cycle clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Cash Conversion Cycle":
                        Toast.makeText(RatiosActivity.this, "Cash Conversion Cycle clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Total Asset Turnover":
                        Toast.makeText(RatiosActivity.this, "Total Asset Turnover clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Debt Ratio":
                        Toast.makeText(RatiosActivity.this, "Debt Ratio clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Equity Ratio":
                        Toast.makeText(RatiosActivity.this, "Equity Ratio clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Debt-Equity Ratio":
                        Toast.makeText(RatiosActivity.this, "Debt-Equity Ratio clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Times Interest- Earned":
                        Toast.makeText(RatiosActivity.this, "Times Interest- Earned clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Earnings per Share":
                        Toast.makeText(RatiosActivity.this, "Earnings per Share clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Price-Earnings Ratio":
                        Toast.makeText(RatiosActivity.this, "Price-Earnings Ratio clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Dividend Pay-out Ratio":
                        Toast.makeText(RatiosActivity.this, "Dividend Pay-out Ratio clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Dividend Yield Ratio":
                        Toast.makeText(RatiosActivity.this, "Dividend Yield Ratio clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case "Book value per Share":
                        Toast.makeText(RatiosActivity.this, "Book value per Share clicked", Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });

    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Profitability Ratios");
        listDataHeader.add("Liquidity Ratios");
        listDataHeader.add("Management Efficiency Ratios");
        listDataHeader.add("Leverage Ratios");
        listDataHeader.add("Valuation and Growth Ratios");

        // Adding child data
        List<String> profitabilityRatios = new ArrayList<String>();
        profitabilityRatios.add("Gross Profit Rate");
        profitabilityRatios.add("Return on Sales");
        profitabilityRatios.add("Return on Assets");
        profitabilityRatios.add("Return on Stockholder\'s Equity");


        List<String> liquidityRatios = new ArrayList<String>();
        liquidityRatios.add("Current Ratio");
        liquidityRatios.add("Acid Test Ratio");
        liquidityRatios.add("Cash Ratio");
        liquidityRatios.add("Net Working Ratio");



        List<String> managementEfficiencyRatios = new ArrayList<String>();
        managementEfficiencyRatios.add("Receivable Turnover");
        managementEfficiencyRatios.add("Days Sales Outstanding");
        managementEfficiencyRatios.add("Inventory Turnover");
        managementEfficiencyRatios.add("Days Inventory Outstanding");
        managementEfficiencyRatios.add("Accounts Payable Turnover");
        managementEfficiencyRatios.add("Days Payable Outstanding");
        managementEfficiencyRatios.add("Operating Cycle");
        managementEfficiencyRatios.add("Cash Conversion Cycle");
        managementEfficiencyRatios.add("Total Asset Turnover");

        List<String> leverageRatios = new ArrayList<String>();
        leverageRatios.add("Debt Ratio");
        leverageRatios.add("Equity Ratio");
        leverageRatios.add("Debt-Equity Ratio");
        leverageRatios.add("Times Interest Earned");

        List<String> valuationAndGrowthRatios = new ArrayList<String>();
        valuationAndGrowthRatios.add("Earnings per Share");
        valuationAndGrowthRatios.add("Price-Earnings Ratio");
        valuationAndGrowthRatios.add("Dividend Pay-out Ratio");
        valuationAndGrowthRatios.add("Dividend Yield Ratio");
        valuationAndGrowthRatios.add("Book Value per Share");



        listDataChild.put(listDataHeader.get(0), profitabilityRatios); // Header, Child data
        listDataChild.put(listDataHeader.get(1), liquidityRatios);
        listDataChild.put(listDataHeader.get(2), managementEfficiencyRatios);
        listDataChild.put(listDataHeader.get(3), leverageRatios);
        listDataChild.put(listDataHeader.get(4), valuationAndGrowthRatios);

    }
}