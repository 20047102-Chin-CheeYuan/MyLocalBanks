package sg.edu.rp.c346.id20047102.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    boolean favouriteDBS = true;
    boolean favouriteOCBC = true;
    boolean favouriteUOB = true;

    String bankOption = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(getString(R.string.dbsbank));
            tvOCBC.setText(getString(R.string.ocbcbank));
            tvUOB.setText(getString(R.string.uobbank));
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(getString(R.string.dbsbankChinese));
            tvOCBC.setText(getString(R.string.ocbcbankChinese));
            tvUOB.setText(getString(R.string.uobbankChinese));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == tvDBS) {
            bankOption = getString(R.string.dbsbank);
        } else if (v == tvOCBC) {
            bankOption = getString(R.string.ocbcbank);
        } else if (v == tvUOB) {
            bankOption = getString(R.string.uobbank);
        }

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0, 2, 2, "Toggle Favourite");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (bankOption.equalsIgnoreCase(getString(R.string.dbsbank))) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsURL)));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.dbsNum)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (favouriteDBS) {
                    tvDBS.setTextColor(Color.RED);
                    favouriteDBS = false;
                } else {
                    tvDBS.setTextColor(Color.BLACK);
                    favouriteDBS = true;
                }
                return true;
            }

        } else if (bankOption.equalsIgnoreCase(getString(R.string.ocbcbank))) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcURL)));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.ocbcNum)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (favouriteOCBC) {
                    tvOCBC.setTextColor(Color.RED);
                    favouriteOCBC = false;
                } else {
                    tvOCBC.setTextColor(Color.BLACK);
                    favouriteOCBC = true;
                }
                return true;
            }

        } else if (bankOption.equalsIgnoreCase(getString(R.string.uobbank))) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobURL)));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobNum)));
                startActivity(intentCall);
                return true;
            } else if (item.getItemId() == 2) {
                if (favouriteUOB) {
                    tvUOB.setTextColor(Color.RED);
                    favouriteUOB = false;
                } else {
                    tvUOB.setTextColor(Color.BLACK);
                    favouriteUOB = true;
                }
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }
}