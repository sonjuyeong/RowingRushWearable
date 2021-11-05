package com.example.rowingrushwearable;

import static com.example.rowingrushwearable.CalendarUtils.daysInWeekArray;
import static com.example.rowingrushwearable.CalendarUtils.monthYearFromDate;
import static com.example.rowingrushwearable.CalendarUtils.selectedDate;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeekViewActivity extends AppCompatActivity implements com.example.rowingrushwearable.CalendarAdapter.OnItemListener, InterfaceFAN,InterfaceFilejson.game {
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        initWidgets();
        setWeekView();
        String url = "https://script.google.com/macros/s/AKfycbylvetNHghg319R-1_Nid9Ei_JV4ef-89ZJnyeHTo6JyOi4ofSmdSFH6MbbMq8l5nz2/exec?action=read";
        Request request=new Request();
        request.getItems(url,"list",this);




    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        eventListView = findViewById(R.id.eventListView);
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(com.example.rowingrushwearable.CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(com.example.rowingrushwearable.CalendarUtils.selectedDate);
        com.example.rowingrushwearable.CalendarAdapter calendarAdapter = new com.example.rowingrushwearable.CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        setEventAdpater();
    }


    public void previousWeekAction(View view)
    {
        com.example.rowingrushwearable.CalendarUtils.selectedDate = com.example.rowingrushwearable.CalendarUtils.selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void nextWeekAction(View view)
    {
        com.example.rowingrushwearable.CalendarUtils.selectedDate = com.example.rowingrushwearable.CalendarUtils.selectedDate.plusWeeks(1);
        setWeekView();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        com.example.rowingrushwearable.CalendarUtils.selectedDate = date;
        setWeekView();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setEventAdpater();
    }

    private void setEventAdpater()
    {
        ArrayList<Event> today = Event.eventsForDate(com.example.rowingrushwearable.CalendarUtils.formattedDate(selectedDate));
        EventAdapter todayAdapter = new EventAdapter(getApplicationContext(), today);
        eventListView.setAdapter(todayAdapter);
    }





    @Override
    public void successFAN(String json) throws JSONException {
        com.example.rowingrushwearable.Filejson filejson = new com.example.rowingrushwearable.Filejson();
        filejson.game(json,this);
    }

    @Override
    public void errorFAN(String error) {
        Toast.makeText(this,error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void game() {
        ArrayList<Event> todaygame = Event.eventsForDate(com.example.rowingrushwearable.CalendarUtils.formattedDate(selectedDate));
        EventAdapter todaygameadapter = new EventAdapter(getApplicationContext(), todaygame);
        eventListView.setAdapter(todaygameadapter);

    }
}