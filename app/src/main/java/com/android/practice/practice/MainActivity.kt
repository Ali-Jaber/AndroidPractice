package com.android.practice.practice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.practice.practice.Notifications.MyNotifications
import com.android.practice.practice.recyclerview.UserRecyclerView
import com.android.practice.practice.dialog.CustomAlertDialog
import com.android.practice.practice.autocompletetext.CountryAutoCompleteText
import com.android.practice.practice.customview.MyCustomView
import com.android.practice.practice.dialog.MyBottomSheet
import com.android.practice.practice.fragment.MainFragment
import com.android.practice.practice.fragment.dialog.MyDialogFragment
import com.android.practice.practice.fragment.fragmenttofragment.FragmentToFragment
import com.android.practice.practice.fragment.toolbar.FragmentToolBar
import com.android.practice.practice.fragment.transferdata.MainTransferFragment
import com.android.practice.practice.listview.ListView
import com.android.practice.practice.spinner.SpinnerMain
import com.android.practice.practice.viewpager.MyPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            startActivity(Intent(this, ListView::class.java))
        }

        btn2.setOnClickListener {
            startActivity(Intent(this, UserRecyclerView::class.java))
        }

        btn3.setOnClickListener {
            startActivity(Intent(this, CollapsingToolbar::class.java))
        }

        btn4.setOnClickListener {
            startActivity(Intent(this, Drawer::class.java))
        }

        btn5.setOnClickListener {
            startActivity(Intent(this, GroupMenu::class.java))
        }

        btn6.setOnClickListener {
            startActivity(Intent(this, RadioButton::class.java))
        }

        btn7.setOnClickListener {
            startActivity(Intent(this, SpinnerMain::class.java))
        }
//        btn7.setOnClickListener {
//            startActivity(Intent(this, Spinner::class.java))
//        }

        btn8.setOnClickListener {
            startActivity(Intent(this, TableLayout::class.java))
        }

        btn9.setOnClickListener {
            startActivity(Intent(this, ScrollVertical::class.java))
        }

        btn10.setOnClickListener {
            startActivity(Intent(this, ScrollHorizontal::class.java))
        }

        btn11.setOnClickListener {
            startActivity(Intent(this, ScrollNested::class.java))
        }

        btn12.setOnClickListener {
            startActivity(Intent(this, LinerLayout::class.java))
        }

        btn13.setOnClickListener {
            startActivity(Intent(this, RelativeLayout::class.java))
        }

        btn14.setOnClickListener {
            startActivity(Intent(this, CoordinatorLayout::class.java))
        }

        btn15.setOnClickListener {
            startActivity(Intent(this, CountryAutoCompleteText::class.java))
        }

        btn16.setOnClickListener {
            startActivity(Intent(this, CustomAlertDialog::class.java))
        }

        btn17.setOnClickListener {
            startActivity(Intent(this, MyNotifications::class.java))
        }

        btn18.setOnClickListener {
            startActivity(Intent(this, MainFragment::class.java))
        }

        btn19.setOnClickListener {
            startActivity(Intent(this, MainTransferFragment::class.java))
        }

        btn20.setOnClickListener {
            startActivity(Intent(this, FragmentToFragment::class.java))
        }

        btn21.setOnClickListener {
            startActivity(Intent(this, FragmentToolBar::class.java))
        }

        btn22.setOnClickListener {
            startActivity(Intent(this, MyPager::class.java))
        }

        btn23.setOnClickListener {
            startActivity(Intent(this, MyCustomView::class.java))
        }

        btn24.setOnClickListener {
            startActivity(Intent(this, MyDialogFragment::class.java))
        }

        btn25.setOnClickListener {
            startActivity(Intent(this, MyBottomSheet::class.java))
        }
    }
}