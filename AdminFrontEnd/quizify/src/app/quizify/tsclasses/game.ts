import { Question } from './question';
import { Category } from './category';
import { Topic } from './topic';
import { Genre } from './genre';
import { Tag } from './tag';

export class Game {
    id: number;
    name: string;
    category: Category;
    topic: Topic;
    genre: Genre;
    tag: Tag;
    level: string;
    imageUrl: string;
    numOfQuestion: number;
    questions: Question[];
    timeDuration: number;
    liked: number;
    playCount: number;
    rules: string[];

}
