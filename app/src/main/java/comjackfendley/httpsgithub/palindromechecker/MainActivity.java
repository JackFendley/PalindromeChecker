/**
 * Name: Jack Fendley
 * Course: CS30S
 * Teacher: Mr. Hardman
 * Lab #4
 * Date Last Modified: 4/27/2018
 *
 */
package comjackfendley.httpsgithub.palindromechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mUserInput;
    private TextView mResult;
    private TextView mErrorMessage;

    @Override
    /**
     * onCreate is the method that is executed when the activity begins
     *
     * @param savedInstanceState is a bundle of data used to restore the activity from a previous instance
     *
     * @return Nothing is returned
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserInput = (EditText) findViewById(R.id.et_user_input );
        mResult = (TextView) findViewById( R.id.tv_result);
        mErrorMessage = (TextView) findViewById(R.id.tv_error_message);

        mUserInput.addTextChangedListener( palInputWatcher );
    }

    private final TextWatcher palInputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        /**
         * afterTextChanged is the method that is executed when the user enters text into the editable object
         *
         * @param editable is the editable object the user types input into
         *
         * @return Nothing is returned
         */
        public void afterTextChanged(Editable editable)
        {
            String userInput;
            boolean result = false;

            if( editable.length() == 0)
            {
                mResult.setText("");
                mErrorMessage.setText("You must enter a word to check for a palindrome");
            }
            else if( mUserInput.getText().toString().matches(".*\\d+.*"))
            {
                mResult.setText("");
                mErrorMessage.setText("You cannot enter a number. It must be a word. ");
            }
            else
            {
                mErrorMessage.setText("");

                userInput = mUserInput.getText().toString().toUpperCase();

                result = checkPalindrome(userInput, 0);

                if( result == true)
                {
                    mErrorMessage.setText("");
                    mResult.setText(userInput + " is a palindrome");
                }
                else
                {
                    mErrorMessage.setText("");
                    mResult.setText(userInput + " is not a palindrome");
                }
            }


        }
    };
    // This is where the TextWatcher has closed
    /**
     * checkPalindrome checks if a word is a palindrome recursively (calls itself multiple times to achieve a specific end)
     *
     * @param userWord is the word that is being checked for palindrome
     *
     * @return a boolean that stores the users word
     */
    private boolean checkPalindrome ( String userWord, int i)
    {
        boolean result;

        int indexFromEnd = userWord.length() - i - 1;

        if(userWord.charAt(i) == userWord.charAt(indexFromEnd))
        {
            if(i == indexFromEnd || i == indexFromEnd - 1)
            {
                result = true;
            }
            else
            {
                result = checkPalindrome(userWord, i+ 1);
            }
        }
        else
        {
            result = false;
        }

        return result;
    }
}