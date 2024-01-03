package com.example.tapdash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.example.tapdash.databinding.ActivitySecondBinding;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding bindingSecond;
    private final List<int[]> combinationSecondList = new ArrayList<>();
    private int[] boxSecondPositions = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //16 zero
    private int playerSecondTurn = 1;
    private int totalSecondSelectedBoxes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingSecond = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(bindingSecond.getRoot());

        combinationSecondList.add(new int[] {0,1,2,3});
        combinationSecondList.add(new int[] {4,5,6,7});
        combinationSecondList.add(new int[] {8,9,10,11});
        combinationSecondList.add(new int[] {12,13,14,15});
        combinationSecondList.add(new int[] {0,4,8,12});
        combinationSecondList.add(new int[] {1,5,9,13});
        combinationSecondList.add(new int[] {2,6,10,14});
        combinationSecondList.add(new int[] {3,7,11,15});
        combinationSecondList.add(new int[] {0,5,10,15});
        combinationSecondList.add(new int[] {3,6,9,12});

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        bindingSecond.playerOneName.setText(getPlayerOneName);
        bindingSecond.playerTwoName.setText(getPlayerTwoName);

        bindingSecond.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(0)){
                    performAction((ImageView) view, 0);
                }
            }
        });

        bindingSecond.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(1)){
                    performAction((ImageView) view, 1);
                }
            }
        });
        bindingSecond.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(2)){
                    performAction((ImageView) view, 2);
                }
            }
        });
        bindingSecond.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(3)){
                    performAction((ImageView) view, 3);
                }
            }
        });
        bindingSecond.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(4)){
                    performAction((ImageView) view, 4);
                }
            }
        });
        bindingSecond.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(5)){
                    performAction((ImageView) view, 5);
                }
            }
        });
        bindingSecond.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(6)){
                    performAction((ImageView) view, 6);
                }
            }
        });
        bindingSecond.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(7)){
                    performAction((ImageView) view, 7);
                }
            }
        });
        bindingSecond.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(8)){
                    performAction((ImageView) view, 8);
                }
            }
        });
        bindingSecond.image10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(9)){
                    performAction((ImageView) view, 9);
                }
            }
        });
        bindingSecond.image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(10)){
                    performAction((ImageView) view, 10);
                }
            }
        });
        bindingSecond.image12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(11)){
                    performAction((ImageView) view, 11);
                }
            }
        });
        bindingSecond.image13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(12)){
                    performAction((ImageView) view, 12);
                }
            }
        });
        bindingSecond.image14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(13)){
                    performAction((ImageView) view, 13);
                }
            }
        });
        bindingSecond.image15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(14)){
                    performAction((ImageView) view, 14);
                }
            }
        });

        bindingSecond.image16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(15)){
                    performAction((ImageView) view, 15);
                }
            }
        });

    }

    private void performAction(ImageView  imageView, int selectedSecondBoxPosition) {
        boxSecondPositions[selectedSecondBoxPosition] = playerSecondTurn;

        if (playerSecondTurn == 1) {
            imageView.setImageResource(R.drawable.icons_x);
            if (checkResults()) {
                ResultSecondDialog resultSecondDialog = new ResultSecondDialog(SecondActivity.this, bindingSecond.playerOneName.getText().toString()
                        + " is a Winner!", SecondActivity.this);
                resultSecondDialog.setCancelable(false);
                resultSecondDialog.show();
            } else if(totalSecondSelectedBoxes == 16) {
                ResultSecondDialog resultSecondDialog = new ResultSecondDialog(SecondActivity.this, "Match Draw", SecondActivity.this);
                resultSecondDialog.setCancelable(false);
                resultSecondDialog.show();
            } else {
                changePlayerTurn(2);
                totalSecondSelectedBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.icons_o);
            if (checkResults()) {
                ResultSecondDialog resultSecondDialog = new ResultSecondDialog(SecondActivity.this, bindingSecond.playerTwoName.getText().toString()
                        + " is a Winner!", SecondActivity.this);
                resultSecondDialog.setCancelable(false);
                resultSecondDialog.show();
            } else if(totalSecondSelectedBoxes == 16) {
                ResultSecondDialog resultSecondDialog = new ResultSecondDialog(SecondActivity.this, "Match Draw", SecondActivity.this);
                resultSecondDialog.setCancelable(false);
                resultSecondDialog.show();
            } else {
                changePlayerTurn(1);
                totalSecondSelectedBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentSecondPlayerTurn) {
        playerSecondTurn = currentSecondPlayerTurn;
        if (playerSecondTurn == 1) {
            bindingSecond.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            bindingSecond.playerTwoLayout.setBackgroundResource(R.drawable.white_box);
        } else {
            bindingSecond.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            bindingSecond.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }

    private boolean checkResults(){
        boolean response = false;
        for (int i = 0; i < combinationSecondList.size(); i++){
            final int[] combinationSecond = combinationSecondList.get(i);

            if (boxSecondPositions[combinationSecond[0]] == playerSecondTurn && boxSecondPositions[combinationSecond[1]] == playerSecondTurn &&
                    boxSecondPositions[combinationSecond[2]] == playerSecondTurn) {
                response = true;
            }
        }
        return response;
    }

    private boolean isBoxSelectable(int boxSecondPosition) {
        boolean response = false;
        if (boxSecondPositions[boxSecondPosition] == 0) {
            response = true;
        }
        return response;
    }

    public void restartMatch(){
        boxSecondPositions = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //16 zero
        playerSecondTurn = 1;
        totalSecondSelectedBoxes = 1;

        bindingSecond.image1.setImageResource(R.drawable.white_box);
        bindingSecond.image2.setImageResource(R.drawable.white_box);
        bindingSecond.image3.setImageResource(R.drawable.white_box);
        bindingSecond.image4.setImageResource(R.drawable.white_box);
        bindingSecond.image5.setImageResource(R.drawable.white_box);
        bindingSecond.image6.setImageResource(R.drawable.white_box);
        bindingSecond.image7.setImageResource(R.drawable.white_box);
        bindingSecond.image8.setImageResource(R.drawable.white_box);
        bindingSecond.image9.setImageResource(R.drawable.white_box);
        bindingSecond.image10.setImageResource(R.drawable.white_box);
        bindingSecond.image11.setImageResource(R.drawable.white_box);
        bindingSecond.image12.setImageResource(R.drawable.white_box);
        bindingSecond.image13.setImageResource(R.drawable.white_box);
        bindingSecond.image14.setImageResource(R.drawable.white_box);
        bindingSecond.image15.setImageResource(R.drawable.white_box);
        bindingSecond.image16.setImageResource(R.drawable.white_box);
    }
}