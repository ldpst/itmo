package story.community;

import story.person.shorty.Shorty;

import java.util.ArrayList;
import java.util.List;

public class Community {
    private List<Shorty> members = new ArrayList<>();

    public Community() {
    }

    public Community(List<Shorty> members) {
        this.add(members);
    }

    public void add(List<Shorty> members) {
        this.members.addAll(members);
    }

    public void add(Shorty shorty) {
        members.add(shorty);
    }

    public void remove(Shorty shorty) {
        members.remove(shorty);
    }

    public String getCommaSeparatedNames() {
        try {
            String commaSeparatedNames = this.members.get(0).toString();
            for (int i = 1; i < this.members.size(); i++) {
                commaSeparatedNames += ", " + this.members.get(i).toString();
            }
            return commaSeparatedNames;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException(); // unchecked exception
        }
    }

    public List<Shorty> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return this.getCommaSeparatedNames();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Community other)) {
            return false;
        }
        List<Shorty> copyOfMembers = new ArrayList<Shorty>(this.members);
        copyOfMembers.sort(new CommunityComparator());

        List<Shorty> copyOfOtherMembers = new ArrayList<Shorty>(other.members);
        copyOfOtherMembers.sort(new CommunityComparator());

        return copyOfMembers.equals(copyOfOtherMembers);
    }

    @Override
    public int hashCode() {
        return this.members.toString().hashCode();
    }
}
