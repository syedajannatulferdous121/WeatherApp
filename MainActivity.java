import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView temperatureTextView;
    private TextView weatherTextView;
    private ImageView weatherIconImageView;
    private Button refreshButton;
    private ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureTextView = findViewById(R.id.temperatureTextView);
        weatherTextView = findViewById(R.id.weatherTextView);
        weatherIconImageView = findViewById(R.id.weatherIconImageView);
        refreshButton = findViewById(R.id.refreshButton);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show loading progress bar
                loadingProgressBar.setVisibility(View.VISIBLE);

                // Simulate data fetching delay
                // Replace with actual data retrieval logic
                simulateDataFetchingDelay();
            }
        });
    }

    private void simulateDataFetchingDelay() {
        // Simulate a delay of 2 seconds to fetch weather data
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // Hide loading progress bar
                        loadingProgressBar.setVisibility(View.GONE);

                        // Update weather data
                        updateWeatherData("25°C", "Sunny", R.drawable.sun_icon);
                    }
                },
                2000
        );
    }

    private void updateWeatherData(String temperature, String weatherCondition, int weatherIconResId) {
        temperatureTextView.setText(temperature);
        weatherTextView.setText(weatherCondition);
        weatherIconImageView.setImageResource(weatherIconResId);
    }
    
    private void showError(String errorMessage) {
        temperatureTextView.setText("");
        weatherTextView.setText(errorMessage);
        weatherIconImageView.setImageResource(R.drawable.error_icon);
    }
}
