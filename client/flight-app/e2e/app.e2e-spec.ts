import { FlightAppPage } from './app.po';

describe('flight-app App', () => {
  let page: FlightAppPage;

  beforeEach(() => {
    page = new FlightAppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
