package story;

class CommunityComparator implements java.util.Comparator<Shorty> {
    @Override
    public int compare(Shorty a, Shorty b) {
        return a.getName().compareTo(b.getName());
    }
}