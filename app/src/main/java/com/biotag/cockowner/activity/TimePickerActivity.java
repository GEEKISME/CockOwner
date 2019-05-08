package com.biotag.cockowner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.biotag.cockowner.R;
import com.biotag.cockowner.common.GetAttrString;
import com.biotag.cockowner.customdialog.RxToast;
import com.biotag.cockowner.customview.NumberPickerView;

public class TimePickerActivity extends UserBaseActivity {
    private RelativeLayout rl_back;
    private RelativeLayout share;
    private NumberPickerView picker_unit;
    private NumberPickerView picker_decimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        initview();
        initlistener();
    }

    private void initlistener() {
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        share.setVisibility(View.VISIBLE);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String units = picker_unit.getContentByCurrValue();

                String decimals = picker_decimal.getContentByCurrValue();
                int unit = Integer.parseInt(units);
                int decimal = Integer.parseInt(decimals);
                if(units.equals("0")&&decimals.equals("00")){
//                    Toast.makeText(TimePickerActivity.this, "The weight is invalid !", Toast.LENGTH_SHORT).show();
                    RxToast.warning(TimePickerActivity.this, "The weight is invalid !", Toast.LENGTH_SHORT, true).show();

                }else {
                    Intent intent = new Intent();
                    intent.putExtra("unit",units);
                    intent.putExtra("decimal",decimals);
                    intent.putExtra("orgid",unit*100+decimal);
                    setResult(RESULT_OK,intent);
                    finish();
                }
//                Toast.makeText(TimePickerActivity.this, "unit is "+units+"  ,decimal is "+decimals, Toast.LENGTH_SHORT).show();


//                Toast.makeText(TimePickerActivity.this, "要传的orgID 是"+(unit*100+decimal), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initview() {
        RelativeLayout titlebar_chooseweight = findViewById(R.id.titlebar_chooseweight);
        rl_back = titlebar_chooseweight.findViewById(R.id.rl_back);
        share = titlebar_chooseweight.findViewById(R.id.share);
        TextView activity_title = titlebar_chooseweight.findViewById(R.id.activity_title);
        activity_title.setText("Gamefowl Weight");
        TextView nextstep = titlebar_chooseweight.findViewById(R.id.nextstep);
        nextstep.setText(GetAttrString.getBasic_confirm());
        NumberPickerView picker_danwei = findViewById(R.id.picker_danwei);
        picker_decimal = findViewById(R.id.picker_decimal);
        picker_unit = findViewById(R.id.picker_unit);

    }
}
