package homework.BraceChecker;

import work.Stack.Brace;
import work.Stack.StackBrace;

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
        StackBrace st = new StackBrace(srchBrace());
        Brace pop = null;
        for(int i = 0; i < text.length(); i++)
        {
            char last;
            char c = text.charAt(i);
            switch(c)
            {
                case '{':
                case '[':
                case '(':
                    st.push(new Brace(c, i));
                    break;
                case ')':
                     pop = st.pop();
                    if(pop == null)
                    {
                        System.out.println("Error: Close " + c + " but not opened on" + i);
                    }
                    else
                    {
                        last = pop.getBrace();
                        if(last != '(')
                        {
                            System.out.println("Error: Close " + c + " but open " + last + " at " + i);
                        }
                    }
                    break;
                case '}':
                    pop = st.pop();
                    if(pop == null)
                    {
                        System.out.println("Error: Close " + c + " but not opened on" + i);
                    }
                    else
                    {
                        last = pop.getBrace();
                        if(last != '{')
                        {
                            System.out.println("Error: Close " + c + " but open " + last + " at " + i);
                        }
                    }
                    break;
                case ']':
                    pop = st.pop();
                    if(pop == null)
                    {
                        System.out.println("Error: Close " + c + " but not opened on" + i);
                    }
                    else
                    {
                        last = pop.getBrace();
                        if(last != '[')
                        {
                            System.out.println("Error: Close " + c + " but open " + last + " at " + i);
                        }
                    }

            }
        }
        Brace last;
        while((last = st.pop()) != null)
        {
            System.out.println("Error: Opened" + last.getBrace() + " but not closed no " + (last.getIndex() + 1));
        }

    }
}
