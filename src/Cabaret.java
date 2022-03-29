import java.lang.reflect.Array;
import java.util.ArrayList;
public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name)
    {
        this.name = name;
        performers = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Performer> getPerformers()
    {
        return performers;
    }

    public boolean addPerformer(Performer person)
    {
        if(performers.indexOf(person)==-1)
        {
            performers.add(person);
            return true;
        }
        return false;
    }

    public boolean removePerformer(Performer person)
    {
        if(performers.indexOf(person)!=-1)
        {
            performers.remove(person);
            return true;
        }
        return false;
    }

    public double averagePerformerAge()
    {
        double sum = 0.0;
        for(Performer person: performers)
        {
            sum+=person.getAge();
        }
        return sum/performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> temp = new ArrayList<>();
        for(Performer person: performers)
        {
            if(person.getAge()>=age)
            {
                temp.add(person);
            }
        }
        return temp;
    }

    public void groupRehearsal()
    {
        for(Performer person: performers)
        {
            System.out.println("REHEARSAL CALL! " + person.getName());
           if(person instanceof Comedian)
           {
               Comedian temp = (Comedian) person;
               temp.rehearse(false);
           }
           else
           {
               person.rehearse();
           }
        }
    }

    public void cabaretShow()
    {
        for (Performer person : performers)
        {
            System.out.println("Welcome to the cabaret! Next act up… " + person.getName());
            if(person instanceof Dancer)
            {
                Dancer temp = (Dancer) person;
                temp.pirouette(2);
                temp.perform();
            }
            else
            {
                person.perform();
            }
        }
    }


}
