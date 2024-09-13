package homework.BraceChecker;

import work.Stack.Stack;

public class BraceChecker
{
    private String text;

    public BraceChecker(String text)
    {
        this.text = text;
    }

    private int srchBrace()
    {
        int count = 0;
        for(char c : text.toCharArray())
        {
            if(c == '(' || c == '{' || c == '[' || c == ')' || c == '}' || c == ']')
            {
                count++;
            }
        }
        return count;
    }

    public void check()
    {
        Stack st = new Stack(srchBrace());
        int pop;

        for(int i = 0; i < text.length(); i++)
        {
            char last;
            char c = text.charAt(i);
            switch(c)
            {
                case '{':
                case '[':
                case '(':
                    st.push(c);
                    break;
                case ')':
                    pop = st.pop();
                    if(pop == 0)
                    {
                        System.out.println("Error: Close " + c + " but not opened on" + i);
                    }
                    else
                    {
                        last = (char)pop;
                        if(last != '(')
                        {
                            System.out.println("Error: Close " + c + " but open " + last + " at " + i);
                        }
                    }
                    break;
                case '}':
                    pop = st.pop();
                    if(pop == 0)
                    {
                        System.out.println("Error: Close " + c + " but not opened on" + i);
                    }
                    else
                    {
                        last = (char)pop;
                        if(last != '{')
                        {
                            System.out.println("Error: Close " + c + " but open " + last + " at " + i);
                        }
                    }
                    break;
                case ']':
                    pop = st.pop();
                    if(pop == 0)
                    {
                        System.out.println("Error: Close " + c + " but not opened on" + i);
                    }
                    else
                    {
                        last = (char)pop;
                        if(last != '[')
                        {
                            System.out.println("Error: Close " + c + " but open " + last + " at " + i);
                        }
                    }

            }
        }
        int last;
        while((last = st.pop()) != 0)
        {
            System.out.println("Error: Opened" + (char)last + " but not closed");
        }

    }
}
