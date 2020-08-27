package interceptfilter;

public class Client {
    FilterManager filterManager;
    public void setFilterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }
    public void sendRequest(String request) {
        filterManager.filterRequest(request);
    }

    public static void main(String[] args) {
        Client client = new Client();
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());

        client.setFilterManager(filterManager);
        client.sendRequest("Home");
    }
}
