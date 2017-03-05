import { Angular2FrontEndPage } from './app.po';

describe('angular2-front-end App', () => {
  let page: Angular2FrontEndPage;

  beforeEach(() => {
    page = new Angular2FrontEndPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
