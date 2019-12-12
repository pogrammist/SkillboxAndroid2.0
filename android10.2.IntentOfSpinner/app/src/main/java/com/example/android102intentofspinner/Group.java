package com.example.android102intentofspinner;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<Card> cards = new ArrayList<>();
    private Card card;

    public Group(String[] groups) {
        cards.add(new Card(groups[0],
                R.string.info_jedi,
                R.drawable.image_jedi,
                R.raw.star_wars_the_last_jedi_01_main_title_and_escape));
        cards.add(new Card(groups[1],
                R.string.info_mandalorian,
                R.drawable.image_mandalorian,
                R.raw.star_wars_the_last_jedi_04_the_supremacy));
        cards.add(new Card(groups[2],
                R.string.info_skywalker,
                R.drawable.image_skywalker,
                R.raw.star_wars_the_last_jedi_11_the_fathiers));
        cards.add(new Card(groups[3],
                R.string.info_sith,
                R.drawable.image_sith,
                R.raw.star_wars_the_last_jedi_14_a_new_alliance));
    }

    public int getMelody(int position) {
        card = cards.get(position);
        int melody = card.getMelody();
        return melody;
    }

    public Card getCard() {
        return card;
    }
}
