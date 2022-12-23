const { getFilesOf } = require('./util.js');

module.exports = {
  base: '/java_programming/',
  assetsPublicPath: '/',
  title: "Java 프로그래밍 개념 & 코드",
  plugins: ['@vuepress/last-updated'],
  themeConfig: {
    nav: [
      { text: 'Home', link: '/' }
    ],
    sidebar: [
      ['/', 'Java Programming'],
      {
        title: '변수',
        path: '/src/Chapter_1/',
        children: getFilesOf('src/Chapter_1'),
      },
      {
        title: '연산자',
        path: '/src/Chapter_2/',
        children: getFilesOf('src/Chapter_2'),
      },
      {
        title: '조건/반복문',
        path: '/src/Chapter_3/',
        children: getFilesOf('src/Chapter_3'),
      },
      {
        title: '참조타입',
        path: '/src/Chapter_4/',
        children: getFilesOf('src/Chapter_4'),
      },
    ],
    repo: 'ithingv34/java_programming',
    repoLabel: 'GitHub',
    editLinks: true,
    docsBranch: 'main',
    editLinkText: '잘못된 부분이 있다면 수정해주세요🙌!',
  },
};
