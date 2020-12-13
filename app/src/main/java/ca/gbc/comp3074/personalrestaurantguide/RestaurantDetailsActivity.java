package ca.gbc.comp3074.personalrestaurantguide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RestaurantDetailsActivity extends AppCompatActivity {
    private ImageButton fbBtn, twBtn, mailBtn;
    private Button locBtn, directionBtn;
    private TextView nameTxt, addressTxt, phoneTxt, descriptionTxt, tagsTxt;
    private TextView nameLbl, addressLbl, phoneLbl, descriptionLbl, tagsLbl, ratingLbl;
    private RatingBar ratingBarStatic;

    @SuppressLint("IntentReset")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_restaurant);

        Intent i = getIntent();
        String name = i.getExtras().getString("COLUMN_NAME");
        String address = i.getExtras().getString("COLUMN_ADDRESS");
        String phone = i.getExtras().getString("COLUMN_PHONE");
        String description = i.getExtras().getString("COLUMN_DESCRIPTION");
        String ratingBar = i.getExtras().getString("COLUMN_RATING");
        String tags = i.getExtras().getString("COLUMN_TAGS");

        nameLbl = findViewById(R.id.nameLabel);
        addressLbl = findViewById(R.id.addressLabel);
        phoneLbl = findViewById(R.id.phoneLabel);
        descriptionLbl = findViewById(R.id.descriptionLabel);
        tagsLbl = findViewById(R.id.tagsLabel);
        ratingLbl = findViewById(R.id.ratingLabel);

        nameTxt = findViewById(R.id.nameTxt);
        addressTxt = findViewById(R.id.addressTxt);
        phoneTxt = findViewById(R.id.phoneTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        tagsTxt = findViewById(R.id.tagsTxt);
        ratingBarStatic = findViewById(R.id.ratingBarStatic);

        float numStars = Float.parseFloat(ratingBar); //converting rating from string to int

        nameTxt.setText(name);
        addressTxt.setText(address);
        phoneTxt.setText(phone);
        descriptionTxt.setText(description);
        ratingBarStatic.setRating(numStars); //converting rating from int to stars
        tagsTxt.setText(tags);

        fbBtn = findViewById(R.id.fbBtn);
        twBtn = findViewById(R.id.twitterBtn);
        mailBtn = findViewById(R.id.mailBtn);
        locBtn = findViewById(R.id.locBtn);
        directionBtn = findViewById(R.id.directionBtn);

        //back arrow button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        String shareTxt = "Check out this restaurant! It's called " + name + " located at " + address + "!";
        String map = "https://maps.google.co.in/maps?q=" + address;

        /*
           ------------- SHARE BUTTONS MAIL/FB/TWITTER -------------
        */

        fbBtn.setOnClickListener(view -> {
            String fAdd = address.replaceAll("\\s","+");
            String fMap = "https://maps.google.co.in/maps?q="+fAdd;
            String fbPost = "https://www.facebook.com/dialog/feed?app_id=404803923975097&link=" +fMap+
                    "&redirect_uri=https://www.facebook.com/";
            Uri uri = Uri.parse(fbPost);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        });

        mailBtn.setOnClickListener(view -> {
            Intent mail = new Intent(Intent.ACTION_VIEW);
            String mAdd = address.replaceAll("\\s","+");
            String mMap = "https://maps.google.co.in/maps?q="+mAdd;
            mail.setType("text/html");
            mail.setData(Uri.parse("mailto:"));
            mail.putExtra(Intent.EXTRA_SUBJECT, "Check out this restaurant!");
            mail.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml("<p>" + shareTxt + "</p><a>"+mMap+"</a>"));
            startActivity(mail);
        });

        twBtn.setOnClickListener(view -> {
            String tAdd = address.replaceAll("\\s","%2B");
            String tMap = "https://maps.google.co.in/maps?q="+tAdd;
            String tweetUrl = "https://twitter.com/intent/tweet?url=" + tMap + "&text=" + shareTxt;
            Uri uri = Uri.parse(tweetUrl);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        });

        /*
           ------------- SHARE BUTTONS MAIL/FB/TWITTER -------------
        */

        locBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(map));
            startActivity(intent);
        });

        directionBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("google.navigation:q=" + address + ""));
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.addRestaurant) {
            Intent intent = new Intent(this, AddRestaurantActivity.class);
            this.startActivity(intent);
        }
        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            this.startActivity(intent);
        }
        if (item.getItemId() == R.id.restaurants) {
            Intent intent = new Intent(this, RestaurantsActivity.class);
            this.startActivity(intent);
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
