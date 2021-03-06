package edu.utep.cs.cs4330cs.hw4.omok;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Game_Mode_Fragment extends Fragment {
    Button random;
    Button smart;

    //Interface listener
    private GameModeListener listener;

    //Events Game_Mode_Fragment will need
    // to talk to MainActivity for.
    public interface GameModeListener{
        void setMode(int mode);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try {
                if(context instanceof GameModeListener)
                listener = (GameModeListener) context;
        }
        catch (Exception e){
            throw new ClassCastException(context.toString()+
                    "must implment MyListFragment.gameModeListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_mode_fragment,container,false);
        random = (Button) view.findViewById(R.id.easy_button);
        smart =(Button)view.findViewById(R.id.hard_button);
        buttonListeners();
        return view;
    }

    public void buttonListeners(){
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call random strategy
                listener.setMode(0);
            }
        });

        smart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // /Call smart strategy
                listener.setMode(1);
            }
        });
    }
}
