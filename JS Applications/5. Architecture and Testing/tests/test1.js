const { chromium } = require('playwright-chromium');
const { assert } = require('chai');
let browser, page; // Declare reusable variables

describe('E2E tests', () => {
    before(async () => {
        browser = await chromium.launch({headless:false,slowMo:500});
    });
    after(async () => {
        await browser.close();
    });
    beforeEach(async () => {
        page = await browser.newPage();
        await page.goto('http://localhost:3000/01.%20Accordion/index.html')
    });
    afterEach(async () => {
        await page.close();
    });

    it('loads static page', async () => {
        const content = await page.textContent('.accordion .head span');
        assert.equal(content, 'Scalable Vector Graphics', 'div 1 not found');

    })

    describe('toggles content', () => {
        it('first p', async () => {
            await page.click('#main>div:first-child >> button');
            const visible = await page.isVisible('#main>div:first-child >> .extra>p')
            assert.isTrue(visible);
            await page.click('#main>div:first-child >> button');
            const isHidden = await page.isVisible('#main>div:first-child >> .extra>p')
            assert.isFalse(isHidden);
        });
        it('second p', async () => {
            await page.click('#main>div:nth-child(2) >> button');
            const visible = await page.isVisible('#main>div:nth-child(2) >> .extra>p')
            assert.isTrue(visible);
            await page.click('#main>div:nth-child(2) >> button');
            const isHidden = await page.isVisible('#main>div:nth-child(2) >> .extra>p')
            assert.isFalse(isHidden);
        });
        it('third p', async () => {
            await page.click('#main>div:nth-child(3) >> button');
            const visible = await page.isVisible('#main>div:nth-child(3) >> .extra>p')
            assert.isTrue(visible);
            await page.click('#main>div:nth-child(3) >> button');
            const isHidden = await page.isVisible('#main>div:nth-child(3) >> .extra>p')
            assert.isFalse(isHidden);
        });
        it('fourth p', async () => {
            await page.click('#main>div:nth-child(4) >> button');
            const visible = await page.isVisible('#main>div:nth-child(4) >> .extra>p')
            assert.isTrue(visible);
            await page.click('#main>div:nth-child(4) >> button');
            const isHidden = await page.isVisible('#main>div:nth-child(4) >> .extra>p')
            assert.isFalse(isHidden);
        });
    })

    it('checks titles',async()=>{
        const content = await page.$$eval('.head>span',spans=>spans.map(span=>span.textContent));
        assert.include(content,'Scalable Vector Graphics')
        assert.include(content,'Open standard')
        assert.include(content,'Unix')
        assert.include(content,'ALGOL')
    })

});