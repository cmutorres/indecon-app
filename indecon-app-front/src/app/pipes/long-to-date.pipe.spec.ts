import { LongToDatePipe } from './long-to-date.pipe';

describe('LongToDatePipe', () => {
  it('create an instance', () => {
    const pipe = new LongToDatePipe();
    expect(pipe).toBeTruthy();
  });
});
